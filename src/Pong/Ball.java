package Pong;

import java.awt.*;

public class Ball {
    private int size = 20, x, y, vx, vy;
    private double speed = 1.0;
    private Color color = Color.GREEN;


    public Ball(int size, int x, int y, int vx, int vy, double speed, Color color) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void moveBall(){
        // TODO: Erhöhen nach X Aufprällen
        x += (vx * speed);
        y += (vy * speed);
    }

    public void bounceEdges(int width, int height){
        if(y <= 0){
            reverseY();
        } else if (y >= height - size) {
            reverseY();
        }

        if(x <= 0){
            reverseX();
        } else if (x >= width - size) {
            reverseX();
        }
    }

    private void reverseY(){
        vy *= -1;
    }

    public void reverseX(){
        vx *= -1;
    }

    public int getY(){
        return this.y;
    }

    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public void resetBall(){
        // TODO: Zufallsgenerator für Position und Richtung
        x = 315;
        y = 235;
        speed = 1.0;
    }

    public void resetBall(int panel_width, int panel_height){
        int radius = size / 2;
        x = panel_width / 2 - radius;
        y = panel_height / 2 - radius;
    }
}
