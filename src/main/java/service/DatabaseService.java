package service;

import model.Database;
import model.DatabaseAccount;
import model.Event;
import model.IConnectionListener;

public class DatabaseService implements IObserver {

    private final Database database;

    public DatabaseService() {
        database = Database.getInstance();
    }

    public void registerObserver(Event event, IConnectionListener listener) {
        database.registerObserver(event, listener);
    }
    public void unregisterObserver(Event event, IConnectionListener listener) {
        database.unregisterObserver(event, listener);
    }
    public void notifyObservers(Event event) {
        database.notifyObservers(event);
    }

    public boolean connect(DatabaseAccount account) {
        return database.connect(account);
    }
    public boolean query(String query) {
        return database.query(query);
    }
    public String getLastResult() {
        return database.getLastResult();
    }
    public String getLastMessage() {
        return database.getLastMessage();
    }

}
