package gui.panel;

import net.miginfocom.swing.MigLayout;
import service.DatabaseService;
import service.IObserver;

import javax.swing.*;
import java.awt.*;

/**
 * ControlPanel wraps TaskPanel and ConnectionPanel
 */

public class ControlPanel extends JPanel {

    private ConnectionPanel connectionPanel;
    private OperationPanel operationPanel;


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
        operationPanel = new OperationPanel();

        add(connectionPanel, "wrap, grow");
        add(operationPanel, "grow");
    }

}
