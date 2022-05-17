package ru.shishkin.javaLessonFromComputer12.snake;

import javax.swing.*;
import java.awt.*;

class myFrame extends JFrame
{
    public myFrame()
    {
        myPanel p = new myPanel();
        Container cont = getContentPane();
        cont.add(p);
        setTitle("Snake");
        setBounds(0,0,800,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}