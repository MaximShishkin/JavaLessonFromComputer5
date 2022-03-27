package ru.shishkin.javaLessonFromComputer5.newYearsRain;

import javax.swing.*;

public class NewYearsRain {
    public static void main(String[] args) {
        String rez = JOptionPane.showInputDialog(null, "Enter difficulty from 1 to 9:",
                "Enter difficulty", 3);

        int slogn = rez.charAt(0) - '0';

        if ((slogn >= 1) && (slogn <= 7)) {
            FrameNewYearsRain window = new FrameNewYearsRain(slogn);
        }
    }
}
