package ru.shishkin.javaLessonFromComputer5.simplePuzzle;

import javax.swing.*;
import java.awt.*;

public class FrameSimplePuzzle extends JFrame {
    public FrameSimplePuzzle() {
        PanelSimplePuzzle np = new PanelSimplePuzzle();
        Container cont = getContentPane();
        cont.add(np);
        setBounds(0, 0, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
