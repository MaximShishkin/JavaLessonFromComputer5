package ru.shishkin.javaLessonFromComputer12.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelP extends JPanel {
    private Color[] masColor;
    private int tCol = 0;
    private int g = 0;
    private JButton btn;
    private JTextField txt;
    private int mX, mY, mX1, mY1, mX2, mY2;
    private Boolean flag = false;

    private class myMouse1 implements MouseListener {
        public void mouseClicked(MouseEvent e) {}

        public void mousePressed(MouseEvent e) {
            int tX = e.getX();
            int tY = e.getY();
            int mX2 = e.getX();
            int mY2 = e.getY();
            int col = e.getClickCount();
            int btn = e.getButton();

            if ((tX > 0) && (tX < 800) && (tY > 0) && (tY < 50)) {
                if (col == 1) {
                    if (btn == 1) {
                        tCol = tX / 100;
                    }
                }
            }
        }

        public void mouseReleased(MouseEvent e) {
            flag = false;
        }

        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    private class myMouse2 implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {
            if (g == 0) {
                mX1 = mX2;
                mY1 = mY2;
                g = 1;
            }

            int tX = e.getX();
            int tY = e.getY();

            if ((tY > 50) && (g == 1)) {
                mX1 = mX;
                mY1 = mY;
                mX = tX;
                mY = tY;
                flag = true;

                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {
            int tX = e.getX();
            int tY = e.getY();

            if ((tX > 0) && (tX < 800) && (tY > 0) && (tY < 50)) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }

    public PanelP() {
        setLayout(null);
        btn = new JButton("OK");
        btn.setForeground(Color.BLUE);
        btn.setBounds(300, 400, 100, 50);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = txt.getText();
                JOptionPane.showMessageDialog(null, s);
            }
        });
        add(btn);

        txt = new JTextField();
        txt.setBackground(Color.WHITE);
        txt.setFont(new Font("arial", 0, 40));
        txt.setBounds(50, 200, 400, 100);
        add(txt);

        addMouseListener(new myMouse1());
        addMouseMotionListener(new myMouse2());

        setFocusable(true);

        masColor = new Color[8];
        masColor[0] = Color.BLACK;
        masColor[1] = Color.GREEN;
        masColor[2] = Color.BLUE;
        masColor[3] = Color.RED;
        masColor[4] = Color.YELLOW;
        masColor[5] = Color.WHITE;
        masColor[6] = Color.ORANGE;
        masColor[7] = Color.GRAY;
    }


    public void paintComponent(Graphics gr) {
        for (int i = 0; i < 8; i++) {
            gr.setColor(masColor[i]);
            gr.fillRect(i * 100, 0, 100, 50);
        }

        if (flag == true) {
            gr.setColor(masColor[tCol]);
            gr.drawLine(mX1, mY1, mX, mY);
            //gr.fillRect(mX, mY, 3, 3);
        }
    }
}