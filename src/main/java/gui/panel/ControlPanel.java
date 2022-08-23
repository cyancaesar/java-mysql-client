package gui.panel;

import model.Event;
import model.IConnectionListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * ControlPanel wraps TaskPanel and ConnectionPanel
 */

public class ControlPanel extends JPanel {

    private JPanel connectionPanel;
    private JPanel taskPanel;

    private final LayoutManager mgr = new MigLayout(
            "insets 0",
            "[center, grow]",
            "[center, grow]"
    );

    public ControlPanel() {
        initPanel();
    }

    private void initPanel() {
        setLayout(mgr);
        setPreferredSize(new Dimension(200,200));

        connectionPanel = new ConnectionPanel();
        taskPanel = new OperationPanel();

        add(connectionPanel, "wrap, grow");
        add(taskPanel, "grow");

    }

}
