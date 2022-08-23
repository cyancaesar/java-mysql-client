package controller;

import gui.panel.ConnectionPanel;
import model.Database;
import model.DatabaseAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionController implements ActionListener {

    private ConnectionPanel connectionPanel;

    public ConnectionController(ConnectionPanel view) {
        connectionPanel = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("connect")) {
            DatabaseAccount databaseAccount = DatabaseAccount.getInstance();
            databaseAccount.setDbName(connectionPanel.getDbnameField().getText());
            databaseAccount.setAccountInfo("host", connectionPanel.getHostField().getText());
            databaseAccount.setAccountInfo("username", connectionPanel.getUserField().getText());
            databaseAccount.setAccountInfo("password", new String(connectionPanel.getPassField().getPassword()));

            Database database = Database.getInstance();
            boolean result = database.connect(databaseAccount);
            if (!result) {
                JOptionPane.showMessageDialog(null, "Not connected");
            }
        }
    }

}
