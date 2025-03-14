package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

public class Pong {
    // JFrame Graphikkomponente aus Swing-Framework
    private static JFrame frame = new JFrame("Pong");

    // final sorgt dafür, dass die Werte nachträglich NICHT verändert werden können
    // => WINDOW_* sind Konstanten
    private static final int WINDOW_WIDTH = 655, WINDOW_HEIGHT = 520;

    public static void main(String[] args) {
        // Programm muss erst erfahren, dass es durch schließen beendet werden soll
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Maximiert das Fenster
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        PongGame pg = new PongGame();

        frame.add(pg);

        // Stellt Größe des Fensters ein
        frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        // Einstellung, dass Fenstergröße nicht geändert werden kann
        //frame.setResizable(false);

        frame.setVisible(true);

        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pg.logic();
                pg.repaint();
            }
        });
        timer.start();
    }

}
