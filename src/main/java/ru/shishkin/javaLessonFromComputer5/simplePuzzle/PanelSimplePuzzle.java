package ru.shishkin.javaLessonFromComputer5.simplePuzzle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class PanelSimplePuzzle extends JPanel {
    private int x = 3, y = 3;
    private Image fon;
    JButton btnStart, btnSlow, btnStop;
    private JLabel lb;
    Image[] mas = new Image[15];
    int[][] data = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    public class myMouse1 implements MouseListener {
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    public class myMouse2 implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }


    public PanelSimplePuzzle() {
        addMouseListener(new myMouse1());
        addMouseMotionListener(new myMouse2());

        try {
            fon = ImageIO.read(new File("./fon.png"));
            for (int i = 0; i < 15; i++) {
                mas[i] = ImageIO.read(new File("./k" + (i + 1) + ".png"));
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        Timer nt = new Timer(25, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        setLayout(null);

        btnStart = new JButton();
        btnStart.setText("START");
        btnStart.setForeground(Color.MAGENTA);
        btnStart.setBounds(430, 30, 100, 50);
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int a = 0; a < 1000; a++) {
                    int napr = (int) (Math.random() * 4);

                    if ((napr == 0) && (x > 0)) {
                        data[x][y] = data[x - 1][y];
                        data[x - 1][y] = 0;
                        x--;
                    } else if ((napr == 1) && (y < 3)) {
                        data[x][y] = data[x][y + 1];
                        data[x][y + 1] = 0;
                        y++;
                    } else if ((napr == 2) && (x < 3)) {
                        data[x][y] = data[x + 1][y];
                        data[x + 1][y] = 0;
                        x++;
                    } else if ((napr == 3) && (y > 0)) {
                        data[x][y] = data[x][y - 1];
                        data[x][y - 1] = 0;
                        y--;
                    }
                    repaint();
                }
            }
        });
        add(btnStart);

        btnSlow = new JButton();
        btnSlow.setText("SLOW");
        btnSlow.setForeground(Color.PINK);
        btnSlow.setBounds(430, 150, 100, 50);
        btnSlow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int a = 0; a < 1000; a++) {
                    int napr = (int) (Math.random() * 4);

                    if ((napr == 0) && (x > 0)) {
                        data[x][y] = data[x - 1][y];
                        data[x - 1][y] = 0;
                        x--;
                    } else if ((napr == 1) && (y < 3)) {
                        data[x][y] = data[x][y + 1];
                        data[x][y + 1] = 0;
                        y++;
                    } else if ((napr == 2) && (x < 3)) {
                        data[x][y] = data[x + 1][y];
                        data[x + 1][y] = 0;
                        x++;
                    } else if ((napr == 3) && (y > 0)) {
                        data[x][y] = data[x][y - 1];
                        data[x][y - 1] = 0;
                        y--;
                    }
                    repaint();
                }
            }
        });
        add(btnSlow);

        btnStop = new JButton();
        btnStop.setText("STOP");
        btnStop.setForeground(Color.RED);
        btnStop.setBounds(430, 230, 100, 50);
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        add(btnStop);

        lb = new JLabel("Score: 0");
        lb.setForeground(Color.WHITE);
        lb.setFont(new Font("arial", 0, 32));
        lb.setBounds(420, 300, 150, 50);
        add(lb);
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(fon, 0, 0, null);

        gr.setColor(Color.YELLOW);
        for (int i = 0; i < 5; i++) {
            gr.drawLine(10 + i * 70, 10, 10 + i * 70, 290);
            gr.drawLine(10, 10 + i * 70, 290, 10 + i * 70);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[j][i] != 0)
                    gr.drawImage(mas[data[j][i] - 1], i * 70 + 11, j * 70 + 11, null);
            }
        }
    }
}
