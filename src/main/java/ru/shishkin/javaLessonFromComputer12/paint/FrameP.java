package ru.shishkin.javaLessonFromComputer12.paint;

import javax.swing.*;
import java.awt.*;

// ����� ����
class FrameP extends JFrame {

    // ����������� ������ ����
    public FrameP() {
        // ������� �������� � ��������� ����
        setBounds(0, 0, 800, 600);
        // ������� ��������� ����
        setTitle("������ � �����");

        // ������������� ��������� ������ ����������
        // ��� �������� ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ������ ��������� �������� ����
        setResizable(false);

        // �������� ������� ������
        PanelP pan = new PanelP();

        // ��������� ����������� (��������) ����
        Container con = getContentPane();
        // ������������ (��������) ������ � ����
        con.add(pan);

        // ������� ���� �������
        setVisible(true);
    }
}
