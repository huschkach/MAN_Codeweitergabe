package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
*/

public class PongGame extends JPanel implements KeyListener, MouseMotionListener {

    private static final int PANEL_WIDTH = 640;
    private static final int PANEL_HEIGHT = 480;

    private int keyboardY = -1, mouseY;

    private int userScore = 0, computerScore = 0;
    private Ball ball;
    private Paddle userPaddle;
    private Paddle computerPaddle;

    public PongGame(){
        ball = new Ball(10, 315, 235, 1, 1, 1, Color.GREEN);
        userPaddle = new Paddle(0, 327, Color.RED, 50);
        computerPaddle = new Paddle(PANEL_WIDTH -12, 327, Color.YELLOW, 50);
    };

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);

        // Automatische Anpassung an Größe des Frames
        Dimension parent = this.getParent().getSize();
        g.fillRect(0,0, parent.width, parent.height);
        computerPaddle.setX(parent.width - Paddle.PADDLE_WIDTH);
        computerPaddle.paint(g);

        g.setColor(Color.RED);
        g.drawString("Score - User 1 [ " + userScore + " ] : [ " + computerScore + " ] Computer", PANEL_WIDTH / 3, 10);

        /*
        g.fillRect(0,0, PANEL_WIDTH, PANEL_HEIGHT);
        */
        userPaddle.paint(g);
        ball.paint(g);

        //  computerPaddle.paint(g);

        // MouseEvent
        addMouseMotionListener(this);

        // KeyBoardEvents
        this.setFocusable(true);
        this.requestFocus(true);
        addKeyListener(this);

    }

    public void logic(){
        ball.moveBall();
        ball.bounceEdges(PANEL_WIDTH, PANEL_HEIGHT);

        if (userPaddle.checkCollision(ball) || computerPaddle.checkCollision(ball)) {
            ball.reverseX();
        }

        if(ball.getX() <= 0){
            computerScore++;
            ball.resetBall();
        }

        if(ball.getX() + ball.getSize() >= PANEL_WIDTH){
            userScore++;
            ball.resetBall();
        }

        userPaddle.movetoY(keyboardY);
        // computerPaddle.movetoY(ball.getY());
        computerPaddle.movetoY(mouseY);
    }



    @Override
    public void keyReleased(KeyEvent e){
        // Für zwei Spieler deutlicher machen, wann das Paddle angehalten werden soll
        keyboardY = -1;
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            // case KeyEvent.VK_UP:
                keyboardY = 0;
                break;
            case KeyEvent.VK_S:
            // case KeyEvent.VK_DOWN:
                keyboardY = PANEL_HEIGHT;
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){
        mouseY = e.getY();
    }

}
