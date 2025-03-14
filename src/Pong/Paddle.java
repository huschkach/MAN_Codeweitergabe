package Pong;

import java.awt.*;

public class Paddle {
    private Color color;
    private int x, y, height;
    public int speed = 2;

    static final int PADDLE_WIDTH = 12;

    public Paddle(int x, int y, Color color, int height){
        this.x = x;
        this.y = y;
        this.color = color;
        this.height = height;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, height);
    }

    public void setX(int x){
        this.x = x;
    }

    public void movetoY(int movePosition){
        int centerY = y + height / 2;

        if(movePosition == -1){
            y = y;
        } else if(centerY > movePosition){
            y -= speed;
        } else if(centerY < movePosition){
            y += speed;
        }
    }

    public boolean checkCollision(Ball b){
        if(b.getX() >= (x - b.getSize()) && b.getX() <= x + PADDLE_WIDTH){
            if ( b.getY() >= y + b.getSize() && b.getY() <= y + height){
                return true;
            }
        }
        return false;
    }
}
