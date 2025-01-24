package system.bld.test.guiSwing;

import javax.swing.*;
import java.awt.*;

/**
 * @author litao
 * @date 2023-01-16
 * @Desc
 */
//定义一个类继承JFrame类
public class SwingTest01 extends JFrame {
    public static void main(String[] args) {

        String title = "這是一个窗口";
        new SwingTest01().createJframe(title);
    }

    public void createJframe(String title){
        //实例化一个JFrame对象
        JFrame frame = new JFrame();
        frame.setTitle(title);

        // 获取一个容器
        Container container = frame.getContentPane();

        container.setLayout(null);

        //设置容器的背景颜色
//        container.setBackground(Color.CYAN);
        //创建一个JLabel标签




        JButton button = btn01(frame);

        container.add(button);

        JLabel jLabel = new JLabel("这是神马呢？");
        //使标签上的文字居中
        //jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel.setBounds(10,35,150,20);
        // 将标签添加到容器中
        container.add(jLabel);

        //setSize(400,300);
        //设置窗体显示位置和大小
        frame.setBounds(400,300,400,300);
        //使窗体可视
        frame.setVisible(true);
        //设置窗体关闭方式
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void dialog01(JFrame frame){
        JDialog jDialog = new JDialog(frame,"第二个窗户",false);

        //创建一个容器
        Container dialogContainer = jDialog.getContentPane();

        //在容器中添加标签
        dialogContainer.add(new JLabel("窗口里面的对话框"));

        //设置对话框窗体大小
        jDialog.setBounds(120, 120, 150, 100);

        jDialog.setVisible(true);
    }

    public JButton btn01(JFrame frame){


//        Container container = frame.getContentPane();
        //定义一个按钮
        JButton button = new JButton("点我弹出对话框");
        button.setBounds(10, 10, 150, 20);

        //为按钮添加鼠标单击事件
        button.addActionListener(e -> {
            //使MyJDialog窗体可见
            dialog01(frame);
        });

//        container.add(button);


        return button;
    }

    /*class JDialog01 extends JDialog{
        public void createMyDialog(){

        }
    }*/
}
