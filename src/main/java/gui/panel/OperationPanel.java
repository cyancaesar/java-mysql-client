package gui.panel;

import model.Event;
import model.IConnectionListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class OperationPanel extends JPanel implements IConnectionListener {

    private LayoutManager mgr = new MigLayout(
            "center, insets 10",
            "[center, grow][center, grow][center, grow]",
            "[center, grow][center, grow][center, grow]"
    );

    private JButton simButton1;
    private JButton simButton2;
    private JButton simButton3;
    private JButton simButton4;
    private JButton simButton5;
    private JButton simButton6;

    public OperationPanel() {
        initPanel();
//        ServiceManager.registerService(Service.DATABASE_CONNECTION, this);
    }

    private void initPanel() {
        setLayout(mgr);
        setBorder(BorderFactory.createTitledBorder("Operation"));

        simButton1 = new JButton("DUMP DATA");
        simButton2 = new JButton("ALTER TABLE");
        simButton3 = new JButton("VANISH TABLE");
        simButton4 = new JButton("ADD COLUMN");
        simButton5 = new JButton("DUMP DATA UNIQUE");
        simButton6 = new JButton("DROP DB");

        simButton1.setEnabled(false);
        simButton2.setEnabled(false);
        simButton3.setEnabled(false);
        simButton4.setEnabled(false);
        simButton5.setEnabled(false);
        simButton6.setEnabled(false);

        add(simButton1, "width 10:150:300");
        add(simButton2, "width 10:150:300");
        add(simButton3, "wrap, width 10:150:300");
        add(simButton4, "width 10:150:300");
        add(simButton5, "width 10:150:300");
        add(simButton6, "width 10:150:300");

    }

    private void unlockButtons() {
        simButton1.setEnabled(true);
        simButton2.setEnabled(true);
        simButton3.setEnabled(true);
        simButton4.setEnabled(true);
        simButton5.setEnabled(true);
        simButton6.setEnabled(true);
    }

    @Override
    public void update(Event event) {
        if (event == Event.DB_CONNECTED) {
            unlockButtons();
        }
    }
}
