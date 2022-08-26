package controller;

import gui.panel.ConsolePanel;
import service.DatabaseService;
import service.ServiceManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsoleController implements ActionListener {

    private ConsolePanel consolePanel;
    private DatabaseService databaseService = ServiceManager.DATABASE_SERVICE;

    public ConsoleController(ConsolePanel consolePanel) {
        this.consolePanel = consolePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("send")) {
            String query = consolePanel.getCommand();
            boolean status = databaseService.query(query);
            System.out.println("Query Status:" + status);
//            databaseService.getLastResult();
//            System.out.println(databaseService.getLastResult());
        }
    }
}
