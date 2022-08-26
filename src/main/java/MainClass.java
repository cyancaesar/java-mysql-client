import gui.MainWindow;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {

        Runnable run = () -> {
            try {
//                FlatLightLaf.setup();
                FlatMonokaiProIJTheme.setup();
                new MainWindow();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        };

        SwingUtilities.invokeLater(run);

    }
}
