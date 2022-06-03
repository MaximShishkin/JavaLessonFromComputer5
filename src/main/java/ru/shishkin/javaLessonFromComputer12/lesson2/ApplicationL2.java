package ru.shishkin.javaLessonFromComputer12.lesson2;

import javax.swing.*;

public class ApplicationL2 {
    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            JFrame wnd = new JFrame();
            wnd.setBounds((int) (Math.random() * 1000),
                    (int) (Math.random() * 800),
                    100, 100);
            wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            wnd.setVisible(true);
        }

        Auto a1 = new Auto();
        a1.color = "red";
        a1.mas = 2000;
        a1.speed = 210;
        a1.zapr(10);

        Auto a2 = new Auto();
        a2.color = "green";
        a2.mas = 1500;
        a2.speed = 250;
        a2.zapr(20);
    }
}