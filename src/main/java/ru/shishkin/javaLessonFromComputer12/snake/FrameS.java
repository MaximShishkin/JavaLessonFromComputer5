package ru.shishkin.javaLessonFromComputer12.snake;

import javax.swing.*;
import java.awt.*;

public class FrameS extends JFrame {
    public FrameS() {
        PanelS p = new PanelS();
        Container cont = getContentPane();
        cont.add(p);
        setTitle("Snake");
        setBounds(0, 0, 800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}