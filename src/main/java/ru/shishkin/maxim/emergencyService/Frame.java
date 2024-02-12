package ru.shishkin.maxim.emergencyService;

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

    public Frame() {
        setTitle("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440 \u043E\u0446\u0435\u043D\u043A\u0438 \u043A\u0430\u0447\u0435\u0441\u0442\u0432\u0430 \u043E\u0431\u0441\u043B\u0443\u0436\u0438\u0432\u0430\u043D\u0438\u044F \u043A\u043E\u043D\u0442\u0430\u043A\u0442-\u0446\u0435\u043D\u0442\u0440\u0430");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1095, 560);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Картинка
        Image myPicture = null;
        try {
            myPicture = ImageIO.read(getClass().getClassLoader().getResource("EmergencyService.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(10, 10, 800, 500);
        contentPane.add(picLabel);

        // Входные данные
        JLabel label = new JLabel("\u0412\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label.setBounds(820, 10, 120, 14);
        contentPane.add(label);

        // Количество операторов
        label_2 = new JLabel("\u041A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043E\u043F\u0435\u0440\u0430\u0442\u043E\u0440\u043E\u0432:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_2.setHorizontalAlignment(SwingConstants.LEFT);
        label_2.setVerticalAlignment(SwingConstants.TOP);
        label_2.setBounds(820, 50, 250, 23);
        contentPane.add(label_2);

        textField = new JTextField();
        textField.setBounds(820, 75, 250, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        // Интенсивность поступления
        label_3 = new JLabel("\u0418\u043D\u0442\u0435\u043D\u0441\u0438\u0432\u043D\u043E\u0441\u0442\u044C \u043F\u043E\u0441\u0442\u0443\u043F\u043B\u0435\u043D\u0438\u044F:");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_3.setVerticalAlignment(SwingConstants.TOP);
        label_3.setHorizontalAlignment(SwingConstants.LEFT);
        label_3.setBounds(820, 100, 250, 23);
        contentPane.add(label_3);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(820, 125, 250, 20);
        contentPane.add(textField_1);

        // Интенсивность обслуживания
        label_4 = new JLabel("\u0418\u043D\u0442\u0435\u043D\u0441\u0438\u0432\u043D\u043E\u0441\u0442\u044C \u043E\u0431\u0441\u043B\u0443\u0436\u0438\u0432\u0430\u043D\u0438\u044F:");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_4.setVerticalAlignment(SwingConstants.TOP);
        label_4.setHorizontalAlignment(SwingConstants.LEFT);
        label_4.setBounds(820, 150, 250, 23);
        contentPane.add(label_4);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(820, 175, 250, 20);
        contentPane.add(textField_2);

        // Кнопка
        JButton button = new JButton("\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String rezultat;
                double V, lymbda, mu;

                V = Double.parseDouble(textField.getText());
                lymbda = Double.parseDouble(textField_1.getText());
                mu = Double.parseDouble(textField_2.getText());

                rezultat = "";




                textArea_1.setText(rezultat);
            }
        });
        button.setBounds(820, 210, 250, 40);
        contentPane.add(button);

        // Выходные данные
        label_1 = new JLabel("\u0412\u044B\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_1.setBounds(820, 275, 250, 14);
        contentPane.add(label_1);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(820, 300, 250, 203);
        contentPane.add(scrollPane);

        textArea_1 = new JTextArea();
        scrollPane.setViewportView(textArea_1);

        setVisible(true);
    }
}
