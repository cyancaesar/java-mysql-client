package model;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Database {

    private static Database INSTANCE = null;
    private Map<Event, List<IConnectionListener>> observers;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private boolean isConnected = false;

    private Database() {
        System.out.println("Created: " + Database.class.getName());
        observers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> observers.put(event, new ArrayList<>()));
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public void registerObserver(Event event, IConnectionListener listener) {
        observers.get(event).add(listener);
    }
    public void unregisterObserver(Event event, IConnectionListener listener) {
        observers.get(event).remove(listener);
    }
    public void notifyObservers(Event event) {
        observers.get(event).forEach(listener -> listener.update(event));
    }

    public boolean connect(DatabaseAccount account) {
        String host     = account.getAccountInfo("host");
        String username = account.getAccountInfo("username");
        String password = account.getAccountInfo("password");
        String dbName   = account.getDbName();
        String url = "jdbc:mysql://" + host + "/" + dbName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException | SQLException classNotFoundException) {
            isConnected = false;
            return false;
        }
        isConnected = true;

        notifyObservers(Event.DB_CONNECTED);
        return true;
    }
    public boolean query(String query) {
        boolean flag = false;
        try {
            flag = statement.execute(query);
        }
        catch (SQLException sqlException) {
            System.out.println("Exception: " + sqlException.getMessage());
        }
        if (flag)
            notifyObservers(Event.DB_UPDATED);
        return flag;
    }

    public String getLastResult() {
        StringBuilder result = new StringBuilder();
        try {
            resultSet = statement.getResultSet();
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columns; ++i) {
                    result.append(resultSet.getString(i)).append(" | ");
                }
                result.append('\n');
            }
        }
        catch (SQLException sqlException) {
            System.out.println("Exception: " + sqlException.getMessage());
        }
        return result.toString();
    }


    public String getDatabaseName() {
        try {
            return connection.getCatalog();
        }
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }
    public String getLastMessage() {
        String msg = "";
        try {
            msg = connection.getSchema();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
