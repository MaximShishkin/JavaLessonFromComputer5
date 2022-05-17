package ru.shishkin.javaLessonFromComputer12.paint;

import javax.swing.*;
import java.awt.*;

// ����� ����
class okno extends JFrame {

    // ����������� ������ ����
    public okno() {
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
        panel pan = new panel();

        // ��������� ����������� (��������) ����
        Container con = getContentPane();
        // ������������ (��������) ������ � ����
        con.add(pan);

        // ������� ���� �������
        setVisible(true);
    }
}
