package service;

import gui.panel.ConnectionPanel;
import model.Database;
import model.Event;
import model.IConnectionListener;

import java.util.*;

public class DatabaseService {

    private final Database database;

    public DatabaseService() {
        database = Database.getInstance();
    }



}
