package gui.panel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private final LayoutManager mgr = new MigLayout(
            "insets 0",
            "[center, grow]0[center, grow]",
            "[center]0[center, grow]"
    );

    private JPanel controlPanel;
    private JPanel consolePanel;
    private JPanel logPanel;

    public MainPanel() {
        initPanel();
    }

    private void initPanel() {
        setLayout(mgr);

        controlPanel = new ControlPanel();
        consolePanel = new ConsolePanel();
        logPanel = new LogPanel();

        add(controlPanel, "grow");
        add(consolePanel, "wrap, grow");
        add(logPanel, "span, grow");
    }

}
