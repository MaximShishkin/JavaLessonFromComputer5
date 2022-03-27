package ru.shishkin.javaLessonFromComputer5.lesson4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lesson4 {
    public static Robot rob = null;

    public static void main(String[] args) {
        try {
            rob = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame wnd = new JFrame();
        wnd.setUndecorated(true);
        wnd.setAlwaysOnTop(true);
        wnd.setLocation(0, 0);
        wnd.setLayout(new FlowLayout());

        JButton[] btn = new JButton[6];

        for (int i = 0; i < 6; i++) {
            btn[i] = new JButton();
            btn[i].setName("b" + i);
            btn[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
                    String name = b.getName();

                    if (name.equals("b0")) {
                        try {
                            ProcessBuilder proc = new ProcessBuilder(
                                    "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
                                    "http:\\club.1c.ru");
                            proc.start();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else if (name.equals("b1")) {
                        for (int i = 500; i >= 0; i--) {
                            rob.mouseMove(i, i);
                            rob.delay(5);
                        }
                        rob.mouseMove(50, 30);
                        rob.mousePress(MouseEvent.BUTTON1_MASK);
                        rob.delay(200);
                        rob.mouseRelease(MouseEvent.BUTTON1_MASK);
                    } else if (name.equals("b2")) {
                        try {
                            ProcessBuilder proc = new ProcessBuilder("calc");
                            proc.start();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        rob.delay(5000);
                        rob.keyPress(KeyEvent.VK_ALT);
                        rob.delay(100);
                        rob.keyPress(KeyEvent.VK_F4);
                        rob.delay(100);
                        rob.keyRelease(KeyEvent.VK_F4);
                        rob.delay(100);
                        rob.keyRelease(KeyEvent.VK_ALT);
                        rob.delay(100);
                    } else if (name.equals("b3")) {
                        for (int i = 0; i < 10; i++) {
                            rob.keyPress(KeyEvent.VK_CAPS_LOCK);
                            rob.delay(500);
                            rob.keyRelease(KeyEvent.VK_CAPS_LOCK);
                            rob.keyPress(KeyEvent.VK_NUM_LOCK);
                            rob.delay(500);
                            rob.keyRelease(KeyEvent.VK_NUM_LOCK);
                            rob.keyPress(KeyEvent.VK_SCROLL_LOCK);
                            rob.delay(500);
                            rob.keyRelease(KeyEvent.VK_SCROLL_LOCK);
                        }
                    } else if (name.equals("b4")) {
                        rob.keyPress(KeyEvent.VK_WINDOWS);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_R);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_R);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_WINDOWS);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_CONTROL);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_CONTROL);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_C);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_C);
                        rob.keyPress(KeyEvent.VK_M);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_M);
                        rob.keyPress(KeyEvent.VK_D);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_D);
                        rob.keyPress(KeyEvent.VK_ENTER);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_ENTER);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_CONTROL);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_CONTROL);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_F);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_F);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_O);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_O);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_R);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_R);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_M);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_M);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_A);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_A);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_T);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_T);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_SPACE);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_SPACE);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_D);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_D);
                        rob.keyPress(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_CONTROL);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_CONTROL);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyPress(KeyEvent.VK_6);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_SHIFT);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_6);
                        rob.keyPress(KeyEvent.VK_ENTER);
                        rob.delay(200);
                        rob.keyRelease(KeyEvent.VK_ENTER);
                    } else if (name.equals("b5")) {
                        System.exit(0);
                    }
                }
            });
            wnd.add(btn[i]);
        }
		
		/*JButton FORMAT = new JButton();
		FORMAT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});*/

        btn[0].setText("Chrome");
        btn[1].setText("Open Chrome");
        btn[2].setText("Calculator");
        btn[3].setText("Push me");
        btn[5].setText("Other");
        btn[4].setText("EXIT");

        wnd.pack();

        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setVisible(true);
    }
}