package gui.panel;

import controller.ConsoleController;
import model.Event;
import model.IConnectionListener;
import net.miginfocom.swing.MigLayout;
import service.ServiceManager;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel extends JPanel implements IConnectionListener {

    private final LayoutManager mgr = new MigLayout(
            "insets 2",
            "[center, grow][]",
            "[center, grow][]"
    );

    private final ConsoleController consoleController;

    private JTextArea consolePane;
    private JButton sendButton;
    private JScrollPane scrollPane;

    public ConsolePanel() {
        consoleController = new ConsoleController(this);
        ServiceManager.DATABASE_SERVICE.registerObserver(Event.DB_CONNECTED, this);
        ServiceManager.DATABASE_SERVICE.registerObserver(Event.DB_DISCONNECTED, this);
        initPanel();
    }

    private void initPanel() {
        setLayout(mgr);

        consolePane = new JTextArea();
        consolePane.setLineWrap(true);
        consolePane.setWrapStyleWord(true);
        consolePane.setColumns(20);
        consolePane.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        consolePane.setEditable(false);

        sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        sendButton.setActionCommand("send");

        scrollPane = new JScrollPane(consolePane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Console"));

        sendButton.addActionListener(consoleController);

        add(scrollPane, "grow, wrap");
        add(sendButton, "grow");

    }

    public String getCommand() {
        return consolePane.getText();
    }

    @Override
    public void update(Event event) {
        if (event == Event.DB_CONNECTED) {
            consolePane.setEditable(true);
            sendButton.setEnabled(true);
        }
    }
}
