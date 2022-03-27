package ru.shishkin.javaLessonFromComputer5.newYearsRain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GiftNewYearsRain {

    public Image img;
    public int x, y;
    public Boolean act;
    Timer timerUpdate;

    public GiftNewYearsRain(Image img) {
        timerUpdate = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vniz();
            }
        });
        this.img = img;
        act = false;
    }

    public void start() {
        timerUpdate.setDelay(10);
        timerUpdate.start();
        y = 250;
        x = 350;
        act = true;
    }

    public void vniz() {
        if (act == true) {
            y += 1;
        }
        if ((y + img.getHeight(null)) >= 470) {
            timerUpdate.stop();
        }
    }

    public void draw(Graphics gr) {
        if (act == true) {
            gr.drawImage(img, x, y, null);
        }
    }
}
