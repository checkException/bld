package system.bld.test.guiSwing.tank;

import java.awt.*;

/**
 * @author litao
 * @date 2025-02-07
 * @Desc 
 */
public class Bullet {
    private int x, y; // 子弹的位置
    private int speed = 10; // 子弹的速度
    private Tank.Direction direction; // 子弹的方向

    public Bullet(int x, int y, Tank.Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move() {
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }

    public boolean isClear(){
        if(x>=TankProperties.rightWidth&&direction== Tank.Direction.RIGHT){
            return true;
        }else if(x<=TankProperties.leftWidth&&direction== Tank.Direction.LEFT){
            return true;
        }else if(y>=TankProperties.bottomHeight&&direction== Tank.Direction.DOWN){
            return true;
        }else if(y<=TankProperties.topHeight&&direction== Tank.Direction.UP){
            return true;
        }

        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        // 绘制子弹
        g.fillOval(x, y, 10, 10);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }
}
