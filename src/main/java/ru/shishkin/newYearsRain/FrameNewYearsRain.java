package ru.shishkin.newYearsRain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameNewYearsRain extends JFrame {
    private PanelNewYearsRain gameP;
    private int slogn;

    private class myKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == 27) {
                System.exit(0);
            } else if (key == 37) {
                if (gameP.x - 30 > -48) gameP.x -= 30;
                else gameP.x = 752;
            } else if (key == 39) {
                if (gameP.x + 30 < 752) gameP.x += 30;
                else gameP.x = -48;
            }
        }

        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public FrameNewYearsRain(int slogn) {
        this.slogn = slogn;
        addKeyListener(new myKey());
        setFocusable(true);

        gameP = new PanelNewYearsRain(slogn);
        Container con = getContentPane();
        con.add(gameP);

        setBounds(0, 0, 800, 600);
        setTitle("New Years rain games");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

