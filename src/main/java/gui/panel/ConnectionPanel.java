package gui.panel;

import controller.ConnectionController;
import model.Event;
import model.IConnectionListener;
import net.miginfocom.swing.MigLayout;
import service.Service;

import javax.swing.*;
import java.awt.*;

public class ConnectionPanel extends JPanel implements IConnectionListener {

    private final LayoutManager mgr = new MigLayout(
            "insets 10",
            "[][grow]",
            "[][]"
    );

    private final ConnectionController connectionController;

    private JLabel hostLabel;
    private JLabel userLabel;
    private JLabel passLabel;
    private JLabel dbnameLabel;
    private JLabel connectionLabel;

    private JTextField hostField;
    private JTextField userField;
    private JPasswordField passField;
    private JTextField dbnameField;

    private JButton connectButton;

    public ConnectionPanel() {
        connectionController = new ConnectionController(this);
//        ServiceManager.registerService(Service.DATABASE_CONNECTION, this);
        initPanel();
    }

    private void initPanel() {
        setLayout(mgr);
        setBorder(BorderFactory.createTitledBorder("Connection"));

        hostLabel = new JLabel("Host address");
        userLabel = new JLabel("User");
        passLabel = new JLabel("Password");
        dbnameLabel = new JLabel("DB name");
        connectionLabel = new JLabel("Not connected");

        hostField = new JTextField("127.0.0.1", 20);
        userField = new JTextField(20);
        passField = new JPasswordField(20);
        dbnameField = new JTextField(20);

        connectButton = new JButton("Connect");

        add(hostLabel);
        add(hostField, "wrap, grow");
        add(userLabel);
        add(userField, "wrap, grow");
        add(passLabel);
        add(passField, "wrap, grow");
        add(dbnameLabel);
        add(dbnameField, "wrap, grow");
        add(connectButton, "span, grow");
        add(connectionLabel, "span, grow");

        connectButton.setActionCommand("connect");
        connectButton.addActionListener(connectionController);
    }

    public JTextField getHostField() {
        return hostField;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPassField() {
        return passField;
    }

    public JTextField getDbnameField() {
        return dbnameField;
    }

    public void setConnectionLabel(String connectionLabel) {
        this.connectionLabel.setText(connectionLabel);
    }

    @Override
    public void update(Event event) {
        if (event == Event.DB_CONNECTED) {
//            connectionLabel.setText("Connected: ".concat(ServiceManager.DATABASE_SERVICE.getDatabaseName()));
        }
    }
}
