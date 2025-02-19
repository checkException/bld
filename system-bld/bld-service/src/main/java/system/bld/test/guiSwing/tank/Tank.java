package system.bld.test.guiSwing.tank;

import cn.hutool.core.util.RandomUtil;

import java.awt.*;

/**
 * @author litao
 * @date 2025-02-07
 * @Desc 
 */
public class Tank {
    private int x, y; // 坦克的位置
    private int speed = 5; // 坦克的速度
    private Direction direction; // 坦克的方向
    private boolean enemy; // 是否是敌方坦克
    //坦克的 宽 高
    private int tankWidth=TankProperties.tankWidth,tankHeight = TankProperties.tankHeight;

    public Tank(int x, int y, Direction direction, boolean enemy) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.enemy = enemy;
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

    public void draw(Graphics g) {
        g.setColor(enemy ? Color.RED : Color.GREEN);
        g.fillRect(x, y, tankWidth, tankHeight); // 绘制坦克

        // 绘制坦克的头部
        int headerX = x+(tankWidth-TankProperties.tankHeadWidth)/2;
        int headerY = y-TankProperties.tankHeadHeight;
        if(this.direction == Direction.DOWN){
            headerX = x+(tankWidth-TankProperties.tankHeadWidth)/2;
            headerY = y+tankHeight;
        }else if(this.direction == Direction.LEFT){
            headerX = x-TankProperties.tankHeadWidth;
            headerY = y+(tankHeight-TankProperties.tankHeadHeight)/2;
        }else if(this.direction == Direction.RIGHT){
            headerX = x+tankWidth;
            headerY = y+(tankHeight-TankProperties.tankHeadHeight)/2;
        }

        g.fillRect(headerX, headerY, TankProperties.tankHeadWidth, TankProperties.tankHeadHeight);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, tankWidth, tankHeight);
    }

    public Bullet fire() {
        return new Bullet(x + 16, y + 16, direction);
    }

    /**
     * 随机方向
     */
    public void randomDirection(){
        if(y>=TankProperties.bottomHeight){
            if(x<=TankProperties.leftWidth){
                System.out.println("到达最左-下边");
                this.direction = Direction.UP;
            }else if(x>=TankProperties.rightWidth){
                System.out.println("到达最右-下边");
                this.direction = Direction.LEFT;
            }else{
                if(this.direction == Direction.DOWN){
                    System.out.println("到达最下边");
                    randomDirection(this.direction);
                }
            }
        }else if(y<=TankProperties.topHeight){
            if(x<=TankProperties.leftWidth){
                System.out.println("到达最左-上边");
                this.direction = Direction.RIGHT;
            }else if(x>=TankProperties.rightWidth){
                System.out.println("到达最右-上边");
                this.direction = Direction.DOWN;
            }else{
                if(this.direction == Direction.UP){
                    System.out.println("到达最上边");
                    randomDirection(this.direction);
                }
            }
        }else if(x<=TankProperties.leftWidth){
            if(y>=TankProperties.bottomHeight){
                System.out.println("到达最左-下边");
                this.direction = Direction.UP;
            }else if(y<=TankProperties.topHeight){
                System.out.println("到达最左-上边");
                this.direction = Direction.RIGHT;
            }else{
                if(this.direction == Direction.LEFT){
                    System.out.println("到达最左边");
                    randomDirection(this.direction);
                }
            }

        }else if(x>=TankProperties.rightWidth){

            if(y>=TankProperties.bottomHeight){
                System.out.println("到达最右-下边");
                this.direction = Direction.LEFT;
            }else if(y<=TankProperties.topHeight){
                System.out.println("到达最右-上边");
                this.direction = Direction.DOWN;
            }else{
                if(this.direction == Direction.RIGHT){
                    System.out.println("到达最右边");
                    randomDirection(this.direction);
                }
            }
        }

    }

    /**
     * 随机获取一个方向，不能月旧方向相同
     * 旧方向
     * @param oldDirect
     */
    private void randomDirection(Direction oldDirect){
        int num = RandomUtil.randomInt(100);
        if(num<25){
            this.direction = Direction.UP;
            if(this.direction == oldDirect)
                this.direction = Direction.RIGHT;
        }else if(num<50){
            this.direction = Direction.DOWN;
            if(this.direction == oldDirect)
                this.direction = Direction.LEFT;
        }else if(num<75){
            this.direction = Direction.RIGHT;
            if(this.direction == oldDirect)
                this.direction = Direction.DOWN;
        }else {
            this.direction = Direction.LEFT;
            if(this.direction == oldDirect)
                this.direction = Direction.UP;
        }
        System.out.println("设置后的方向："+this.direction);
    }

    /**
     * 判断是否可以自动转向，符合就转向，不符合就继续
     *
     */
    public void authTurn(){
        authTurn(this.direction);
    }

    /**
     *
     * @param oldDirect 原有方向
     */
    private void authTurn(Direction oldDirect){
        int num = RandomUtil.randomInt(100);
        if(num>50&&num<53){
            if(x==0){
                this.direction = Direction.RIGHT;
            }else if(x==TankProperties.rightWidth){
                this.direction = Direction.LEFT;
            }else if(y==TankProperties.bottomHeight){
                this.direction = Direction.UP;
            }else if(y==TankProperties.topHeight){
                this.direction = Direction.DOWN;
            }

            if(this.direction != oldDirect){
                System.out.println("自动转向："+oldDirect+" -> "+this.direction);
            }
        }



    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public boolean isEnemy() {
        return enemy;
    }

    public void setEnemy(boolean enemy) {
        this.enemy = enemy;
    }
}
