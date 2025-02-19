package system.bld.test.guiSwing.tank;

import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author litao
 * @date 2025-02-07
 * @Desc
 */
public class GamePanel extends JPanel implements KeyListener {
    private Tank playerTank;
    private List<Bullet> bullets;
    private List<Tank> enemyTanks;

    public GamePanel() {
        playerTank = new Tank(100, 100, Tank.Direction.UP, false);
        bullets = new ArrayList<>();
        enemyTanks = new ArrayList<>();
        enemyTanks.add(new Tank(100, 220, Tank.Direction.UP, true));
        /*enemyTanks.add(new Tank(655, 400, Tank.Direction.DOWN, true));
        enemyTanks.add(new Tank(550, 320, Tank.Direction.LEFT, true));
        enemyTanks.add(new Tank(350, 320, Tank.Direction.RIGHT, true));*/
        setBounds(0,0,TankProperties.panelWidth,TankProperties.panelHeight);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        playerTank.draw(g);
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
        for (Tank enemyTank : enemyTanks) {
            enemyTank.draw(g);
        }
    }

    public void update() {
//        System.out.println(JSON.toJSONString(playerTank));
//        System.out.println(JSON.toJSONString(enemyTanks));

        // 控制子弹移动
        for(int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.move();
            if(bullet.isClear()){
                bullets.remove(bullet);
                System.out.println(JSON.toJSONString(bullets));
            }
        }
        //移动敌方坦克
//        enemyTanksMove();
        //判断是否击中（子弹是否和坦克相接处）
        checkCollisions();

        //重新绘制图片
//        repaint();
    }

    public void repaint(){
        //重新绘制图片
        super.repaint();

    }

    /**
     * 判断胜利条件
     * @return
     */
    public boolean isWin(){

        if(enemyTanks.size()==0){
            System.out.println("胜利");
            return true;
        }

        return false;
    }

    /**
     * 移动敌方坦克
     */
    private void enemyTanksMove(){

        for (Tank enemyTank : new ArrayList<>(enemyTanks)) {
            // 控制到达边界后转向
            if(enemyTank.isEnemy()){
                enemyTank.randomDirection();
                enemyTank.authTurn();
//                System.out.println(JSON.toJSONString(enemyTank));
            }
            enemyTank.move();
        }
    }

    /**
     * 判断是否击中（子弹是否和坦克相接处）
     */
    private void checkCollisions() {
        for (Bullet bullet : new ArrayList<>(bullets)) {
            for (Tank enemyTank : new ArrayList<>(enemyTanks)) {
                if (bullet.getBounds().intersects(enemyTank.getBounds())) {
                    bullets.remove(bullet);
                    enemyTanks.remove(enemyTank);
                    break;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                playerTank.setDirection(Tank.Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                playerTank.setDirection(Tank.Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                playerTank.setDirection(Tank.Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                playerTank.setDirection(Tank.Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                bullets.add(playerTank.fire());
                break;
        }
        // 移动
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                playerTank.move();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}