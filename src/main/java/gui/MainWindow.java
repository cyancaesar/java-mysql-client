package gui;

import gui.panel.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    private JFrame frame;
    private JPanel mainPanel;

    public MainWindow() {
        initGui();
    }

    private void initGui() {
        frame = new JFrame("JDatabaseAccessor");
        frame.setSize(1000,700);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        mainPanel = new MainPanel();
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

}
