package ru.shishkin.javaLessonFromComputer12.simplePuzzle;

import javax.swing.*;
import java.awt.*;

class myFrame extends JFrame
{
    public myFrame()
    {
        myPanel np = new myPanel();
        Container cont = getContentPane();
        cont.add(np);
        setBounds(0, 0, 640, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
