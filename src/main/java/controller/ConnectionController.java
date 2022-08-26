package controller;

import gui.panel.ConnectionPanel;
import model.DatabaseAccount;
import service.DatabaseService;
import service.ServiceManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionController implements ActionListener {

    private ConnectionPanel connectionPanel;
    private DatabaseService databaseService = ServiceManager.DATABASE_SERVICE;

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

            boolean result = databaseService.connect(databaseAccount);
            if (!result) {
                JOptionPane.showMessageDialog(null, "Not connected");
            }
        }
    }

}
