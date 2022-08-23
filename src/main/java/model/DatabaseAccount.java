package model;

import java.util.Properties;

public class DatabaseAccount {

    private static DatabaseAccount INSTANCE = null;

    public Properties accountInfo = new Properties();
    private String dbName;

    private DatabaseAccount() {}

    public static DatabaseAccount getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DatabaseAccount();
        return INSTANCE;
    }

    public String getAccountInfo(String key) {
        return accountInfo.getProperty(key);
    }

    public void setAccountInfo(String key, String value) {
        accountInfo.setProperty(key, value);
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
