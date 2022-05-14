package ru.shishkin.javaLessonFromComputer5.newYearsRain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GiftNewYearsRain {
    protected Image img;
    protected int x, y;
    protected Boolean act;
    protected Timer timerUpdate;

    protected GiftNewYearsRain(Image img) {
        timerUpdate = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vniz();
            }
        });
        this.img = img;
        act = false;
    }

    protected void start() {
        timerUpdate.setDelay(10);
        timerUpdate.start();
        y = 250;
        x = 350;
        act = true;
    }

    protected void vniz() {
        if (act == true) {
            y += 1;
        }
        if ((y + img.getHeight(null)) >= 470) {
            timerUpdate.stop();
        }
    }

    protected void draw(Graphics gr) {
        if (act == true) {
            gr.drawImage(img, x, y, null);
        }
    }
}
