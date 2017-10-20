import ui.GraphFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by joris on 10/14/17.
 */
public class UIMain {

    public static void main(String[] args)
    {
        // set look and feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }


        GraphFrame frame = new GraphFrame();
        frame.setTitle("untitled*");

        // set size
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(50, 50, (int) ss.getWidth() - 100, (int) ss.getHeight() - 100);

        // set visible
        frame.setVisible(true);
    }

}
