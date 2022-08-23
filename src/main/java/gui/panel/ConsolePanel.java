package gui.panel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ConsolePanel extends JPanel {

    private final LayoutManager mgr = new MigLayout(
            "insets 0",
            "[center, grow][]",
            "[center, grow][]"
    );

    private JTextArea consolePane;
    private JButton sendButton;
    private JScrollPane scrollPane;

    public ConsolePanel() {
        initPanel();
    }

    private void initPanel() {
        setLayout(mgr);

        consolePane = new JTextArea();
        consolePane.setLineWrap(true);
        consolePane.setWrapStyleWord(true);
        consolePane.setColumns(20);
        consolePane.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

        sendButton = new JButton("Send");

        scrollPane = new JScrollPane(consolePane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Console"));

        add(scrollPane, "grow, wrap");
        add(sendButton, "grow");

    }

}
