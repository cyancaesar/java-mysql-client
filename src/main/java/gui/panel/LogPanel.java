package gui.panel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class LogPanel extends JPanel {

    public LogPanel() {
        setLayout(new MigLayout(
                "center",
                "[center, grow]",
                "[center, grow]"
        ));

        JTextArea consolePane = new JTextArea();
        consolePane.setWrapStyleWord(true);
        consolePane.setLineWrap(true);
        consolePane.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(consolePane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        scrollPane.setBorder(BorderFactory.createTitledBorder("Log"));

        add(scrollPane, "grow");
    }

}
