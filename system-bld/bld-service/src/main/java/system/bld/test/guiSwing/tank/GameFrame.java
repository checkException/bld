package system.bld.test.guiSwing.tank;

import javax.swing.*;
import java.awt.*;

/**
 * @author litao
 * @date 2025-02-07
 * @Desc 
 */
public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    /**
     * 是否胜利
     */
    private static boolean isWin = false;

    public GameFrame() {
        gamePanel = new GamePanel();
        add(gamePanel);
//        Container container = getContentPane();
        setTitle("Tank Battle");
        setSize(TankProperties.panelWidth, TankProperties.panelHeight);

        //关闭模式，关闭页面时也关闭控制台
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 页面居住
        setLocationRelativeTo(null);
        // 显示界面
        setVisible(true);
        setLayout(null);

        // 游戏循环
        new Thread(() -> {
            while (true) {
                gamePanel.update();
                try {
//                    Thread.sleep(26); // 大约60帧每秒
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 游戏循环
        new Thread(() -> {
            while (true) {
                gamePanel.repaint();
                if(!isWin){
                    if(gamePanel.isWin()){
                        isWin = true;
                        JFrame frame = new JFrame();
                        dialogWinPop(frame);
                    }
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 胜利的弹窗
     * @param frame
     */
    public void dialogWinPop(JFrame frame){
        JDialog jDialog = new JDialog(frame,"胜利",false);

        //创建一个容器
        Container dialogContainer = jDialog.getContentPane();

        JLabel jLabel = new JLabel("恭喜你获得了胜利");
        jLabel.setBounds(10,35,150,20);
        //在容器中添加标签
        dialogContainer.add(jLabel);

        //设置对话框窗体大小
        jDialog.setSize( 150, 100);
        jDialog.setLocationRelativeTo(null);
//        jDialog.setBounds(120, 120, 150, 100);

        jDialog.setVisible(true);
    }
}
