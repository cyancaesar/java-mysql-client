package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Database {

    private static Database INSTANCE = null;
    private Connection connection;
    private Map<Event, List<IConnectionListener>> observers;

    private Database() {
        Arrays.stream(Event.values()).forEach(System.out::println);
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
        }
        catch (ClassNotFoundException | SQLException classNotFoundException) {
            return false;
        }

        return true;
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
}
