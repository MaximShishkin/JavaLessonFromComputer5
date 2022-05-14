package ru.shishkin.javaLessonFromComputer5.planetaryMovement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelPlanetaryMovement extends JPanel {
    private int x = 0, y = 0;
    private int napr = 2;
    private int napr1 = 1, napr2 = 1;
    private Image img;
    private Image img1;

    private class myKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key_ = e.getKeyCode();
            System.out.println(key_);
            if (key_ == 37) napr = 0;
            if (key_ == 39) napr = 2;
            if (key_ == 38) napr = 1;
            if (key_ == 40) napr = 3;
            if (key_ == 32) napr = 4;
        }

        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }

    public PanelPlanetaryMovement() {
        addKeyListener(new myKey());
        setFocusable(true);

        try {
            img1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("planetaryMovement/fon.png"));
            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("planetaryMovement/planeta.png"));
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        Timer nt = new Timer(25, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (napr == 0) {
                    x -= 5;
                    napr1 = napr;
                    napr2 = napr;
                }
                if (napr == 1) {
                    y -= 5;
                    napr1 = napr;
                    napr2 = napr;
                }
                if (napr == 2) {
                    x += 5;
                    napr1 = napr;
                    napr2 = napr;
                }
                if (napr == 3) {
                    y += 5;
                    napr1 = napr;
                    napr2 = napr;
                }
                if (napr == 4) {
                    System.out.println("" + napr + napr1);
                    if (napr1 != 4) {
                        y += 0;
                        x += 0;
                        napr1 = napr;
                    } else if (napr1 == 4) {
                        if (napr2 == 0) x -= 5;
                        if (napr2 == 1) y -= 5;
                        if (napr2 == 2) x += 5;
                        if (napr2 == 3) y += 5;
                    }
                }

                if (x > 470) napr = 0;
                if (x < 0) napr = 2;
                if (y > 270) napr = 1;
                if (y < 0) napr = 3;

                repaint();
            }
        });
        nt.start();
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(img1, 0, 0, null);
        gr.drawImage(img, x, y, null);
    }
}
