package gui.panel;

import model.Event;
import model.IConnectionListener;
import net.miginfocom.swing.MigLayout;
import service.DatabaseService;
import service.ServiceManager;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel implements IConnectionListener {

    private JTextArea consolePane;
    private DatabaseService databaseService = ServiceManager.DATABASE_SERVICE;

    public LogPanel() {
        ServiceManager.DATABASE_SERVICE.registerObserver(Event.DB_CONNECTED, this);
        ServiceManager.DATABASE_SERVICE.registerObserver(Event.DB_DISCONNECTED, this);
        ServiceManager.DATABASE_SERVICE.registerObserver(Event.DB_UPDATED, this);

        setLayout(new MigLayout(
                "center",
                "[center, grow]",
                "[center, grow]"
        ));

        consolePane = new JTextArea();
        consolePane.setWrapStyleWord(true);
        consolePane.setLineWrap(true);
        consolePane.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        consolePane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(consolePane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setBorder(BorderFactory.createTitledBorder("Log"));

        add(scrollPane, "grow");
    }

    @Override
    public void update(Event event) {
        if (event == Event.DB_CONNECTED) {
            consolePane.append("Connection successful" + "\n\n");
        }
        else if (event == Event.DB_UPDATED) {
            System.out.println("LogPanel: received event");
            consolePane.append(databaseService.getLastResult());
            consolePane.append("\n");
        }
    }
}
