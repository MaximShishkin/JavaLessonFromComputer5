package ru.shishkin.javaLessonFromComputer5.newYearsRain;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PanelNewYearsRain extends JPanel {
    private Image shapka;
    private Image fon;
    private int slogn;
    private GiftNewYearsRain[] gamePodar;
    private Image end_game;
    protected int x = 400;
    protected Timer timerUpdate, timerDraw;

    public PanelNewYearsRain(int slogn) {
        this.slogn = slogn;

        try {
            shapka = ImageIO.read(getClass().getClassLoader().getResourceAsStream("newYearsRain/shapka.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            fon = ImageIO.read(getClass().getClassLoader().getResourceAsStream("newYearsRain/fon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            end_game = ImageIO.read(getClass().getClassLoader().getResourceAsStream("newYearsRain/end_game.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        gamePodar = new GiftNewYearsRain[7];

        for (int i = 0; i < 7; i++) {
            try {
                gamePodar[i] = new GiftNewYearsRain(ImageIO.read(getClass().getClassLoader().getResourceAsStream("newYearsRain/p" + i + ".png")));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        timerUpdate = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStart();
            }
        });
        timerUpdate.start();

        timerDraw = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDraw.start();
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.drawImage(fon, 0, 0, null);
        gr.drawImage(shapka, x, 465, null);

        for (int i = 0; i < 7; i++) {
            gamePodar[i].draw(gr);
            if (gamePodar[i].act == true) {
        		   /*if ((gamePodar[i].y+gamePodar[i].img.getHeight(null))>=470)
        		   {
        			    if (Math.abs(gamePodar[i].x - x) > 75)
        			    {
        			        gr.drawImage(end_game, 300, 300, null);
        			    	timerDraw.stop();
        			    	timerUpdate.stop();
        			        break;
        			    }
        			    else gamePodar[i].act=false;
        		   }*/
            }
        }
    }

    private void updateStart() {
        int kol = 0;
        for (int i = 0; i < 7; i++) {
            if (gamePodar[i].act == false) {
                if (kol < slogn) {
                    gamePodar[i].start();
                    break;
                }
            } else kol++;
        }
    }
}