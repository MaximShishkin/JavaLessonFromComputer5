package ru.shishkin.javaLessonFromComputer12.planetaryMovement;

import javax.swing.*;
import java.awt.*;

public class FramePM extends JFrame {
    public FramePM() {
        PanelPM np = new PanelPM();
        Container cont = getContentPane();
        cont.add(np);
        setBounds(0, 0, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
