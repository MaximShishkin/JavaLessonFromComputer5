package ru.shishkin.javaLessonFromComputer12.planetaryMovement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class PanelPM extends JPanel {
    private int x = 0, y = 0, x1 = 500, y1 = 300, XX, YY;
    private int napr = 2;
    private int napr1 = 2;
    private int P = 0;
    private int M = 0;
    private Image img;
    private Image img1;
    private Image img2;

    private class myKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key_ = e.getKeyCode();
            System.out.println(key_);
            if (P == 0) {
                if (key_ == 100) napr = 4;
                if (key_ == 102) napr = 6;
                if (key_ == 104) napr = 8;
                if (key_ == 98) napr = 2;
                if (key_ == 97) napr = 1;
                if (key_ == 99) napr = 3;
                if (key_ == 103) napr = 7;
                if (key_ == 105) napr = 9;
                if (key_ == 101) napr = 5;
                if (key_ == 87) napr1 = 88;
                if (key_ == 83) napr1 = 22;
                if (key_ == 68) napr1 = 66;
                if (key_ == 65) napr1 = 44;
            }
            if (P == 1) {
                if (key_ == 97) napr = 1;
            }
            if (P == 2) {
                if (key_ == 98) napr = 2;
            }
            if (P == 3) {
                if (key_ == 99) napr = 3;
            }
            if (P == 4) {
                if (key_ == 100) napr = 4;
            }
            if (P == 6) {
                if (key_ == 102) napr = 6;
            }
            if (P == 7) {
                if (key_ == 103) napr = 7;
            }
            if (P == 8) {
                if (key_ == 104) napr = 8;
            }
            if (P == 9) {
                if (key_ == 105) napr = 9;
            }
        }

        public void keyReleased(KeyEvent e) {}
        public void keyTyped(KeyEvent e) {}
    }


    public PanelPM() {
        addKeyListener(new myKey());
        setFocusable(true);

        try {
            img = ImageIO.read(new File("./planeta.png"));
            img1 = ImageIO.read(new File("./fon.png"));
            img2 = ImageIO.read(new File("./planeta.png"));
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        Timer nt = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int k = 0;
                if (napr == 5) {
                    XX = x;
                    YY = y;
                    M = P;
                }
                if (napr == 4) {
                    x--;
                    P = 4;
                }
                if (napr == 8) {
                    y--;
                    P = 8;
                }
                if (napr == 6) {
                    x++;
                    P = 6;
                }
                if (napr == 2) {
                    y++;
                    P = 2;
                }
                if (napr == 3) {
                    y++;
                    x++;
                    P = 3;
                }
                if (napr == 1) {
                    y++;
                    x--;
                    P = 1;
                }
                if (napr == 7) {
                    y--;
                    x--;
                    P = 7;
                }
                if (napr == 9) {
                    y--;
                    x++;
                    P = 7;
                }
                if ((x > 500) && (napr == 3)) {
                    napr = 1;
                    k = 1;
                }
                if ((y > 300) && (napr == 3)) {
                    napr = 9;
                    k = 1;
                }
                if ((x < 0) && (napr == 1)) {
                    napr = 3;
                    k = 1;
                }
                if ((y > 300) && (napr == 1)) {
                    napr = 7;
                    k = 1;
                }
                if ((x < 0) && (napr == 7)) {
                    napr = 9;
                    k = 1;
                }
                if ((y <= 0) && (napr == 7)) {
                    napr = 1;
                    k = 1;
                }
                if ((x > 500) && (napr == 9)) {
                    napr = 7;
                    k = 1;
                }
                if ((y < 0) && (napr == 9)) {
                    napr = 3;
                    k = 1;
                }
                if (k == 0) {
                    if (x > 500) {
                        napr = 4;
                    }
                    if (x < 0) {
                        napr = 6;
                    }
                    if (y > 300) {
                        napr = 8;
                    }
                    if (y < 0) {
                        napr = 2;
                    }
                }

                repaint();
            }
        });
        nt.start();
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(img1, 0, 0, null);
        gr.drawImage(img2, x1, y1, null);
        gr.drawImage(img, x, y, null);
    }
}

