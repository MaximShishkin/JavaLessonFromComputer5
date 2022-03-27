package ru.shishkin.javaLessonFromComputer5.planetaryMovement;

import javax.swing.*;
import java.awt.*;

public class FramePlanetaryMovement extends JFrame {
    public FramePlanetaryMovement() {
        PanelPlanetaryMovement np = new PanelPlanetaryMovement();
        Container cont = getContentPane();
        cont.add(np);
        setBounds(0, 0, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
