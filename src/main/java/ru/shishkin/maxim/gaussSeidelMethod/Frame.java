package ru.shishkin.maxim.gaussSeidelMethod;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame {
    private JPanel contentPane;
    private JTextArea textArea_1;
    private JScrollPane scrollPane;
    private JLabel label_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

    public Frame() {
        setTitle("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440 \u043E\u0446\u0435\u043D\u043A\u0438 \u043A\u0430\u0447\u0435\u0441\u0442\u0432\u0430 \u043E\u0431\u0441\u043B\u0443\u0436\u0438\u0432\u0430\u043D\u0438\u044F \u043A\u043E\u043D\u0442\u0430\u043A\u0442-\u0446\u0435\u043D\u0442\u0440\u0430");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 605, 364);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String rezultat;
                double V, lymbda, mu;

                V = Double.parseDouble(textField.getText());
                lymbda = Double.parseDouble(textField_1.getText());
                mu = Double.parseDouble(textField_2.getText());

                textField_3.setText("" + lymbda);
                textField_4.setText("" + mu);
                textField_5.setText("" + V);

                textField_3.setVisible(true);
                textField_4.setVisible(true);
                textField_5.setVisible(true);

                rezultat = getResault(V, lymbda, mu);

                textArea_1.setText(rezultat);
            }
        });
        button.setBounds(475, 24, 107, 40);
        contentPane.add(button);

        JLabel label = new JLabel("\u0412\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label.setBounds(10, 11, 120, 14);
        contentPane.add(label);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(326, 116, 254, 203);
        contentPane.add(scrollPane);

        textArea_1 = new JTextArea();
        scrollPane.setViewportView(textArea_1);

        label_1 = new JLabel("\u0412\u044B\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_1.setBounds(326, 92, 120, 14);
        contentPane.add(label_1);

        Image myPicture = null;
        try {
            myPicture = ImageIO.read(getClass().getClassLoader().getResource("image.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        textField = new JTextField();
        textField.setBounds(10, 44, 131, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(151, 44, 147, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(308, 44, 157, 20);
        contentPane.add(textField_2);

        label_2 = new JLabel("\u041A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043E\u043F\u0435\u0440\u0430\u0442\u043E\u0440\u043E\u0432:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_2.setHorizontalAlignment(SwingConstants.LEFT);
        label_2.setVerticalAlignment(SwingConstants.TOP);
        label_2.setBounds(10, 26, 195, 23);
        contentPane.add(label_2);

        label_3 = new JLabel("\u0418\u043D\u0442\u0435\u043D\u0441\u0438\u0432\u043D\u043E\u0441\u0442\u044C \u043F\u043E\u0441\u0442\u0443\u043F\u043B\u0435\u043D\u0438\u044F:");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_3.setVerticalAlignment(SwingConstants.TOP);
        label_3.setHorizontalAlignment(SwingConstants.LEFT);
        label_3.setBounds(151, 26, 195, 23);
        contentPane.add(label_3);

        label_4 = new JLabel("\u0418\u043D\u0442\u0435\u043D\u0441\u0438\u0432\u043D\u043E\u0441\u0442\u044C \u043E\u0431\u0441\u043B\u0443\u0436\u0438\u0432\u0430\u043D\u0438\u044F:");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        label_4.setVerticalAlignment(SwingConstants.TOP);
        label_4.setHorizontalAlignment(SwingConstants.LEFT);
        label_4.setBounds(308, 26, 195, 23);
        contentPane.add(label_4);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(100, 174, 30, 20);
        textField_3.setVisible(false);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(240, 137, 30, 20);
        textField_4.setVisible(false);
        contentPane.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(208, 239, 24, 20);
        textField_5.setVisible(false);
        contentPane.add(textField_5);

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(10, 75, 272, 250);
        contentPane.add(picLabel);

        setVisible(true);
    }

    private String getResault(double V, double lymbda, double mu) {
        double epsilon = 0.0000000001;
        double P[] = new double[(int) (V + 1)];
        String rezultat = "";

        for (int i = 0; i <= V; i++) {
            P[i] = 1;
        }

        double noi = 1;
        double ncc = 1;
        double ncp;
        double lp;
        double rp;
        double dif;

        do {
            ncp = ncc;
            ncc = 0;

            for (int i = 0; i <= V; i++) {
                lp = 0;
                if (i < V) lp = lp + lymbda;
                if (i > 0) lp = lp + i * mu;
                rp = 0;
                if (i > 0) rp = rp + P[i - 1] * lymbda;
                if (i < V) rp = rp + P[i + 1] * (i + 1) * mu;
                P[i] = rp / lp;
                ncc = ncc + P[i];
            }

            noi++;
            dif = Math.abs(ncc - ncp) / ncc;
        }

        while (dif > epsilon && noi < 1000);

        for (int i = 0; i <= V; i++) {
            P[i] = P[i] / ncc;
            rezultat = rezultat + "P(" + i + ")=" + P[i] + "\n";
            // System.out.println("P(" + i + ")=" + P[i]);
        }

        double p = 0;
        double m = 0;

        for (int i = 0; i <= V; i++) {
            if (i == V) p = P[i];
            if (i > 0) m = m + P[i] * i;
        }

        dif = lymbda - lymbda * p - m * mu;
        rezultat = rezultat + "Доля потерянных заявок: " + "\n";
        rezultat = rezultat + "" + p + "\n";
        rezultat = rezultat + "Среднее количество занятых операторов: " + "\n";
        rezultat = rezultat + "" + m + "\n";

        /*
        System.out.println("Pc=" + p);
        System.out.println("m=" + m);
        System.out.println("dif=" + dif);
         */

        return rezultat;
    }
}
