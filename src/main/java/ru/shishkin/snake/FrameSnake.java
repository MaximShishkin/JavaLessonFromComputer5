package ru.shishkin.snake;

import javax.swing.*;
import java.awt.*;

public class FrameSnake extends JFrame {
    public FrameSnake() {
        PanelSnake p = new PanelSnake();
        Container cont = getContentPane();
        cont.add(p);
        setTitle("Snake");
        setBounds(0, 0, 800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
