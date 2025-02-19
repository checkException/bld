package system.bld.test.guiSwing.tank;

import javax.swing.*;
import java.awt.*;

/**
 * @author litao
 * @date 2025-02-07
 * @Desc 
 */
public class WinPanel extends JPanel {
    int panelWidth = 100;
    int panelHeight = 50;
    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public WinPanel() {
        JLabel jLabel = new JLabel("恭喜你获得了胜利");
        add(jLabel);
        setBackground(Color.WHITE);
        setBounds((TankProperties.panelWidth-panelWidth)/2,(TankProperties.panelHeight-panelHeight)/2,panelWidth,panelHeight);
    }
}
