package ru.shishkin.maxim.contactCenter;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App frame = new App();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public App() {
        setTitle("\u0420\u0430\u0441\u0447\u0435\u0442 \u043F\u0430\u0440\u0430\u043C\u0435\u0442\u0440\u043E\u0432 \u0434\u043B\u044F \u0443\u0441\u043B\u043E\u0436\u043D\u0435\u043D\u043D\u043E\u0439 \u0441\u0438\u0441\u0442\u0435\u043C\u044B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 528, 516);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u0412\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435:");
        label.setBounds(10, 11, 239, 14);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u0412\u044B\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u0430\u043D\u043D\u044B\u0435:");
        label_1.setBounds(259, 11, 275, 14);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u041A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u043E \u043E\u043F\u0435\u0440\u0430\u0442\u043E\u0440\u043E\u0432 \u0438 \u043A\u043E\u043D\u0441\u0443\u043B\u044C\u0442\u0430\u043D\u0442\u043E\u0432:");
        label_2.setBounds(10, 36, 253, 14);
        contentPane.add(label_2);

        JLabel lblO = new JLabel("O:");
        lblO.setBounds(10, 61, 19, 14);
        contentPane.add(lblO);

        JLabel lblO_1 = new JLabel("K1:");
        lblO_1.setBounds(10, 83, 19, 14);
        contentPane.add(lblO_1);

        JLabel lblO_2 = new JLabel("K2:");
        lblO_2.setBounds(10, 104, 19, 14);
        contentPane.add(lblO_2);

        textField = new JTextField();
        textField.setBounds(39, 58, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(39, 101, 86, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(39, 80, 86, 20);
        contentPane.add(textField_2);

        JLabel label_2_1 = new JLabel("\u0412\u0445\u043E\u0434\u043D\u043E\u0439 \u043F\u043E\u0442\u043E\u043A \u0437\u0430\u044F\u0432\u043E\u043A:");
        label_2_1.setBounds(10, 129, 218, 14);
        contentPane.add(label_2_1);

        JLabel label_2_1_1 = new JLabel("\u0412\u044B\u0445\u043E\u0434\u043D\u043E\u0439 \u043F\u043E\u0442\u043E\u043A \u0437\u0430\u044F\u0432\u043E\u043A:");
        label_2_1_1.setBounds(10, 179, 218, 14);
        contentPane.add(label_2_1_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(39, 204, 86, 20);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(39, 148, 86, 20);
        contentPane.add(textField_4);

        JLabel label_2_1_1_1 = new JLabel("\u041A\u043E\u044D\u0444\u0444\u0438\u0446\u0438\u0435\u043D\u0442\u044B \u043D\u0430\u0433\u0440\u0443\u0437\u043A\u0438 \u043D\u0430 \u0433\u0440\u0443\u043F\u043F\u0443:");
        label_2_1_1_1.setBounds(10, 241, 218, 14);
        contentPane.add(label_2_1_1_1);

        JLabel lblO_1_1 = new JLabel("K1:");
        lblO_1_1.setBounds(10, 269, 19, 14);
        contentPane.add(lblO_1_1);

        JLabel lblO_2_1 = new JLabel("K2:");
        lblO_2_1.setBounds(10, 297, 19, 14);
        contentPane.add(lblO_2_1);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(39, 294, 86, 20);
        contentPane.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(39, 266, 86, 20);
        contentPane.add(textField_6);

        JLabel label_2_1_1_1_1 = new JLabel("IVR:");
        label_2_1_1_1_1.setBounds(10, 328, 30, 14);
        contentPane.add(label_2_1_1_1_1);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(39, 325, 86, 20);
        contentPane.add(textField_7);

        JLabel label_2_2 = new JLabel("\u0414\u043E\u043B\u044F \u043D\u0435\u043E\u0431\u0441\u043B\u0443\u0436\u0435\u043D\u043D\u044B\u0445 \u0437\u0430\u044F\u0432\u043E\u043A:");
        label_2_2.setBounds(259, 36, 275, 14);
        contentPane.add(label_2_2);

        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(288, 58, 86, 20);
        contentPane.add(textField_8);

        JLabel label_2_2_1 = new JLabel("\u0421\u0440\u0435\u0434\u043D\u0435\u0435 \u0432\u0440\u0435\u043C\u044F \u043E\u0431\u0441\u043B\u0443\u0436\u0438\u0432\u0430\u043D\u0438\u044F \u0432 \u0441\u0438\u0441\u0442\u0435\u043C\u0435:");
        label_2_2_1.setBounds(259, 83, 275, 14);
        contentPane.add(label_2_2_1);

        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(288, 101, 86, 20);
        contentPane.add(textField_9);

        JLabel label_2_2_1_1 = new JLabel("\u0421\u0440\u0435\u0434\u043D\u0435\u0435 \u043A\u043E\u043B-\u0432\u043E \u0437\u0430\u043D\u044F\u0442\u044B\u0445 \u043E\u043F\u0435\u0440. \u0438 \u043A\u043E\u043D.:");
        label_2_2_1_1.setBounds(259, 129, 275, 14);
        contentPane.add(label_2_2_1_1);

        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(288, 151, 86, 20);
        contentPane.add(textField_10);

        JLabel label_2_2_1_1_1 = new JLabel("\u0414\u043E\u043B\u044F \u043D\u0435\u043E\u0431\u0441\u043B\u0443\u0436\u0435\u043D\u043D\u044B\u0445 \u0437\u0430\u044F\u0432\u043E\u043A \u043F\u043E \u0433\u0440\u0443\u043F\u043F\u0430\u043C:");
        label_2_2_1_1_1.setBounds(259, 182, 275, 14);
        contentPane.add(label_2_2_1_1_1);

        JLabel lblO_3 = new JLabel("O:");
        lblO_3.setBounds(259, 210, 19, 14);
        contentPane.add(lblO_3);

        JLabel lblO_1_2 = new JLabel("K1:");
        lblO_1_2.setBounds(259, 232, 19, 14);
        contentPane.add(lblO_1_2);

        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(288, 229, 86, 20);
        contentPane.add(textField_11);

        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(288, 207, 86, 20);
        contentPane.add(textField_12);

        textField_13 = new JTextField();
        textField_13.setColumns(10);
        textField_13.setBounds(288, 250, 86, 20);
        contentPane.add(textField_13);

        JLabel lblO_2_2 = new JLabel("K2:");
        lblO_2_2.setBounds(259, 253, 19, 14);
        contentPane.add(lblO_2_2);

        JLabel label_2_2_1_1_1_1 = new JLabel("\u0421\u0440\u0435\u0434\u043D\u0435\u0435 \u043A\u043E\u043B\u043B\u0438\u0447\u0435\u0441\u0442\u043E \u0437\u0430\u043D\u044F\u0442\u044B\u0445 \u043F\u043E \u0433\u0440\u0443\u043F\u043F\u0430\u043C:");
        label_2_2_1_1_1_1.setBounds(259, 281, 275, 14);
        contentPane.add(label_2_2_1_1_1_1);

        JLabel lblO_3_1 = new JLabel("O:");
        lblO_3_1.setBounds(259, 309, 19, 14);
        contentPane.add(lblO_3_1);

        textField_14 = new JTextField();
        textField_14.setColumns(10);
        textField_14.setBounds(288, 306, 86, 20);
        contentPane.add(textField_14);

        JLabel lblO_1_2_1 = new JLabel("K1:");
        lblO_1_2_1.setBounds(259, 331, 19, 14);
        contentPane.add(lblO_1_2_1);

        textField_15 = new JTextField();
        textField_15.setColumns(10);
        textField_15.setBounds(288, 328, 86, 20);
        contentPane.add(textField_15);

        textField_16 = new JTextField();
        textField_16.setColumns(10);
        textField_16.setBounds(288, 349, 86, 20);
        contentPane.add(textField_16);

        JLabel lblO_2_2_1 = new JLabel("K2:");
        lblO_2_2_1.setBounds(259, 352, 19, 14);
        contentPane.add(lblO_2_2_1);

        JLabel label_2_2_1_2 = new JLabel("\u0421\u0440\u0435\u0434\u043D\u0435\u0435 \u0432\u0440\u0435\u043C\u044F \u043E\u0431\u0441\u043B\u0443\u0436\u0438\u0432\u0430\u043D\u0438\u044F \u043F\u043E \u0433\u0440\u0443\u043F\u043F\u0430\u043C:");
        label_2_2_1_2.setBounds(259, 377, 275, 14);
        contentPane.add(label_2_2_1_2);

        JLabel lblO_3_1_1 = new JLabel("O:");
        lblO_3_1_1.setBounds(259, 403, 19, 14);
        contentPane.add(lblO_3_1_1);

        textField_17 = new JTextField();
        textField_17.setColumns(10);
        textField_17.setBounds(288, 400, 86, 20);
        contentPane.add(textField_17);

        JLabel lblO_1_2_1_1 = new JLabel("K1:");
        lblO_1_2_1_1.setBounds(259, 425, 19, 14);
        contentPane.add(lblO_1_2_1_1);

        textField_18 = new JTextField();
        textField_18.setColumns(10);
        textField_18.setBounds(288, 422, 86, 20);
        contentPane.add(textField_18);

        JLabel lblO_2_2_1_1 = new JLabel("K2:");
        lblO_2_2_1_1.setBounds(259, 446, 19, 14);
        contentPane.add(lblO_2_2_1_1);

        textField_19 = new JTextField();
        textField_19.setColumns(10);
        textField_19.setBounds(288, 443, 86, 20);
        contentPane.add(textField_19);

        JButton btnNewButton = new JButton("\u0412\u042B\u041F\u041E\u041B\u041D\u0418\u0422\u042C");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new startCalc();
            }
        });
        btnNewButton.setBounds(10, 399, 115, 61);
        contentPane.add(btnNewButton);
    }

    private class startCalc {
        public startCalc() {
            calc();
        }

        private boolean calc() {
            double lambda, qp, qr, a, a1, a2, mu, mu1, mu2, c, c1, c2;
            double sigma, sigma1, sigma2, h, nu;
            double lp, rp, lpt, rpt, ncc, ncp, dif, dif1, dif2, dif3, dif4, tol, delta;
            double mi, mi1, mi2, mit, mw, mw1, mw2, mwt, mr, mrp, q, sum, sum1, x1, x2;
            double pt, pt1, pt2, pc, pc1, pc2, pct, rb, rb1, rb2, rt, rt1, rt2, tw, tw1, tw2, twt, rb11, rb22;
            int z1, z2, z3, z4, z5, z6, nov, noi, j, rm, n, v, v1, v2, w, w1, w2, m, i, i1, i2;
            double[][][][] p = new double[80][80][80][80];
            double[][] ar = new double[100][100];
            double[] nui = new double[100];
            double[] ai = new double[100];

            v = Integer.parseInt(textField.getText());
            w = v;
            v2 = Integer.parseInt(textField_1.getText());
            w2 = v2;
            v1 = Integer.parseInt(textField_2.getText());
            w1 = v1;
            mu = Double.parseDouble(textField_3.getText());
            mu1 = mu;
            mu2 = mu;
            lambda = Double.parseDouble(textField_4.getText());
            a2 = Double.parseDouble(textField_5.getText());
            a1 = Double.parseDouble(textField_6.getText());

            qp = 1 - Double.parseDouble(textField_7.getText());
            qr = 0.0;
            a = 1 - a1 - a2;
            h = 0.8;
            nu = 0;
            rm = 0;
            c = 0.2;
            c1 = 0.5;
            c2 = 0.5;
            sigma = 0.3;
            sigma1 = 0.25;
            sigma2 = 0.25;

            // {nov - number of calculation variants}
            for (nov = 1; nov <= 1; nov++) {
                tol = 1e-12;

                //{started values for probabilities in iteration scheme}
                sum = 0;

                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                p[j][i][i1][i2] = 1;
                            }
                        }
                    }
                }

                //{started values for parameters of iteration process}
                noi = 0;
                ncc = 1;

                //{beginning of iteration scheme  }
                do {
                    ncp = ncc;
                    ncc = 0;      // {lpt:=0;rpt:=0;}

                    //{forming system of state equation}
                    for (j = 0; j <= rm; j++) {
                        for (i = 0; i <= v + w; i++) {
                            for (i1 = 0; i1 <= v1 + w1; i1++) {
                                for (i2 = 0; i2 <= v2 + w2; i2++) {
                                    //{coefficient for p(j,i,i1,i2) in left part system of state equation}
                                    lp = 0;

                                    //{exeptance of  a coming primary call}
                                    if (i < v + w) lp = lp + lambda * qp * a;
                                    if (i1 < v1 + w1) lp = lp + lambda * qp * a1;
                                    if (i2 < v2 + w2) lp = lp + lambda * qp * a2;

                                    // {exeptance of  a coming repeated call}
                                    if (i < v + w) lp = lp + j * nu * qr * a;
                                    if (i1 < v1 + w1) lp = lp + j * nu * qr * a1;
                                    if (i2 < v2 + w2) lp = lp + j * nu * qr * a2;

                                    // {blocking and subsequent repeatition}
                                    if ((i == v + w) && (j < rm)) lp = lp + lambda * h * qp * a;
                                    if ((i1 == v1 + w1) && (j < rm)) lp = lp + lambda * h * qp * a1;
                                    if ((i2 == v2 + w2) && (j < rm)) lp = lp + lambda * h * qp * a2;

                                    //{blocking and subsequent stopping of  repeatition}
                                    if (i == v + w) lp = lp + j * nu * (1 - h) * qr * a;
                                    if (i1 == v1 + w1) lp = lp + j * nu * (1 - h) * qr * a1;
                                    if (i2 == v2 + w2) lp = lp + j * nu * (1 - h) * qr * a2;

                                    // {serving by IVR of  repeated attempt}
                                    lp = lp + j * nu * (1 - qr);

                                    //{serving by operator or cons.}
                                    if (i <= v) lp = lp + i * mu;
                                    if (i > v) lp = lp + v * mu;
                                    if (i1 <= v1) lp = lp + i1 * mu1;
                                    if (i1 > v1) lp = lp + v1 * mu1;
                                    if (i2 <= v2) lp = lp + i2 * mu2;
                                    if (i2 > v2) lp = lp + v2 * mu2;

                                    // {leaving of the waiting positions}
                                    if (i > v) lp = lp + (i - v) * sigma;
                                    if (i1 > v1) lp = lp + (i1 - v1) * sigma1;
                                    if (i2 > v2) lp = lp + (i2 - v2) * sigma2;

                                    //{construction of right part system of state equation: for state (j,i,i1,i2)}
                                    rp = 0;

                                    //  {exeptance of  a coming primary call}
                                    if (i > 0) rp = rp + p[j][i - 1][i1][i2] * lambda * qp * a;
                                    if (i1 > 0) rp = rp + p[j][i][i1 - 1][i2] * lambda * qp * a1;
                                    if (i2 > 0) rp = rp + p[j][i][i1][i2 - 1] * lambda * qp * a2;

                                    // {exeptance of  a coming repeated call}
                                    if ((i > 0) && (j < rm)) rp = rp + p[j + 1][i - 1][i1][i2] * (j + 1) * nu * qr * a;
                                    if ((i1 > 0) && (j < rm))
                                        rp = rp + p[j + 1][i][i1 - 1][i2] * (j + 1) * nu * qr * a1;
                                    if ((i2 > 0) && (j < rm))
                                        rp = rp + p[j + 1][i][i1][i2 - 1] * (j + 1) * nu * qr * a2;

                                    //  {blocking and subsequent repeatition}
                                    if ((i == v + w) && (j > 0)) rp = rp + p[j - 1][i][i1][i2] * lambda * h * qp * a;
                                    if ((i1 == v1 + w1) && (j > 0))
                                        rp = rp + p[j - 1][i][i1][i2] * lambda * h * qp * a1;
                                    if ((i2 == v2 + w2) && (j > 0))
                                        rp = rp + p[j - 1][i][i1][i2] * lambda * h * qp * a2;

                                    //  {blocking and subsequent stopping of  repeatition}
                                    if ((i == v + w) && (j < rm))
                                        rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - h) * qr * a;
                                    if ((i1 == v1 + w1) && (j < rm))
                                        rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - h) * qr * a1;
                                    if ((i2 == v2 + w2) && (j < rm))
                                        rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - h) * qr * a2;

                                    //  {serving by IVR of  repeated attempt}
                                    if (j < rm) rp = rp + p[j + 1][i][i1][i2] * (j + 1) * nu * (1 - qr);

                                    //  {serving by operator}
                                    if (i + 1 <= v) rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * (1 - c);
                                    if ((i + 1 <= v + w) && (i + 1 > v))
                                        rp = rp + p[j][i + 1][i1][i2] * v * mu * (1 - c);

                                    //   {transition to the first group}
                                    if ((i + 1 <= v) && (i1 > 0))
                                        rp = rp + p[j][i + 1][i1 - 1][i2] * (i + 1) * mu * c * c1;
                                    if ((i + 1 <= v) && (i1 == v1 + w1) && (j < rm))
                                        rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c1 * (1 - h);
                                    if ((i + 1 <= v) && (i1 == v1 + w1) && (j == rm))
                                        rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c1;
                                    if ((i + 1 <= v) && (i1 == v1 + w1) && (j > 0))
                                        rp = rp + p[j - 1][i + 1][i1][i2] * (i + 1) * mu * c * c1 * h;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i1 > 0))
                                        rp = rp + p[j][i + 1][i1 - 1][i2] * v * mu * c * c1;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j < rm))
                                        rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c1 * (1 - h);
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j == rm))
                                        rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c1;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j > 0))
                                        rp = rp + p[j - 1][i + 1][i1][i2] * v * mu * c * c1 * h;

                                    //   {transition to the second group}
                                    if ((i + 1 <= v) && (i2 > 0))
                                        rp = rp + p[j][i + 1][i1][i2 - 1] * (i + 1) * mu * c * c2;
                                    if ((i + 1 <= v) && (i2 == v2 + w2) && (j < rm))
                                        rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c2 * (1 - h);
                                    if ((i + 1 <= v) && (i2 == v2 + w2) && (j == rm))
                                        rp = rp + p[j][i + 1][i1][i2] * (i + 1) * mu * c * c2;
                                    if ((i + 1 <= v) && (i2 == v2 + w2) && (j > 0))
                                        rp = rp + p[j - 1][i + 1][i1][i2] * (i + 1) * mu * c * c2 * h;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i2 > 0))
                                        rp = rp + p[j][i + 1][i1][i2 - 1] * v * mu * c * c2;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j < rm))
                                        rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c2 * (1 - h);
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j == rm))
                                        rp = rp + p[j][i + 1][i1][i2] * v * mu * c * c2;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j > 0))
                                        rp = rp + p[j - 1][i + 1][i1][i2] * v * mu * c * c2 * h;

                                    //    {serving by consultant}
                                    if (i1 + 1 <= v1) rp = rp + p[j][i][i1 + 1][i2] * (i1 + 1) * mu1;
                                    if (i2 + 1 <= v2) rp = rp + p[j][i][i1][i2 + 1] * (i2 + 1) * mu2;
                                    if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1)) rp = rp + p[j][i][i1 + 1][i2] * v1 * mu1;
                                    if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2)) rp = rp + p[j][i][i1][i2 + 1] * v2 * mu2;

                                    //     {leaving of the waiting positions out of c-c or to repeatiton}
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (j < rm))
                                        rp = rp + p[j][i + 1][i1][i2] * (i + 1 - v) * sigma * (1 - h);
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (j == rm))
                                        rp = rp + p[j][i + 1][i1][i2] * (i + 1 - v) * sigma;
                                    if ((i + 1 <= v + w) && (i + 1 > v) && (j > 0))
                                        rp = rp + p[j - 1][i + 1][i1][i2] * (i + 1 - v) * sigma * h;
                                    if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j < rm))
                                        rp = rp + p[j][i][i1 + 1][i2] * (i1 + 1 - v1) * sigma1 * (1 - h);
                                    if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j == rm))
                                        rp = rp + p[j][i][i1 + 1][i2] * (i1 + 1 - v1) * sigma1;
                                    if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j > 0))
                                        rp = rp + p[j - 1][i][i1 + 1][i2] * (i1 + 1 - v1) * sigma1 * h;
                                    if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j < rm))
                                        rp = rp + p[j][i][i1][i2 + 1] * (i2 + 1 - v2) * sigma2 * (1 - h);
                                    if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j == rm))
                                        rp = rp + p[j][i][i1][i2 + 1] * (i2 + 1 - v2) * sigma2;
                                    if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j > 0))
                                        rp = rp + p[j - 1][i][i1][i2 + 1] * (i2 + 1 - v2) * sigma2 * h;

                                    //    {calculation of the next step of iteration process}
                                    p[j][i][i1][i2] = rp / lp;    // { lpt:=lpt+lp; rpt:=rpt+rp;}

                                    //    {calculation of normalizing condition}
                                    ncc = ncc + p[j][i][i1][i2];
                                }
                            }
                        }
                    }  // {cykle of j,i,i1,i2}

                    //{calculation of current number of iteration step}
                    noi = noi + 1;

                    // {checking the validity of the system of state equation construction}
                    //{calculation of normalized differencebetween successive sum of probabilities}
                    dif = Math.abs(ncc - ncp) / ncc;
				/*if(noi % 100==0)
				{
					//System.out.println("number of iteration="+noi+"norm.  difference="+dif);
				}
				//  writeln('number of iteration=',noi:4,' ','norm.  difference=',dif:12);
				 */
                    // {checking of tolerence condition}
                }
                while ((dif >= tol) || (noi <= 900));

                System.out.println("iteration process finished");

                // {normalization of state probabilities}
                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                p[j][i][i1][i2] = p[j][i][i1][i2] / ncc;
                            }
                        }
                    }
                }

                //{calculation of mean values of model's parameters presented as state components}
                mi = 0;
                mi1 = 0;
                mi2 = 0;
                mw = 0;
                mw1 = 0;
                mw2 = 0;
                mr = 0;

                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                if (i <= v) mi = mi + p[j][i][i1][i2] * i;
                                if (i > v) mi = mi + p[j][i][i1][i2] * v;
                                if (i > v) mw = mw + p[j][i][i1][i2] * (i - v);
                                if (i1 <= v1) mi1 = mi1 + p[j][i][i1][i2] * i1;
                                if (i1 > v1) mi1 = mi1 + p[j][i][i1][i2] * v1;
                                if (i1 > v1) mw1 = mw1 + p[j][i][i1][i2] * (i1 - v1);
                                if (i2 <= v2) mi2 = mi2 + p[j][i][i1][i2] * i2;
                                if (i2 > v2) mi2 = mi2 + p[j][i][i1][i2] * v2;
                                if (i2 > v2) mw2 = mw2 + p[j][i][i1][i2] * (i2 - v2);
                                mr = mr + p[j][i][i1][i2] * j;
                            }
                        }
                    }
                }

                //{probablities of resource occupation (pt) on phases of servicing}
                pt = 0;
                pt1 = 0;
                pt2 = 0;

                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                if (i == v + w) pt = pt + p[j][i][i1][i2];
                                if (i1 == v1 + w1) pt1 = pt1 + p[j][i][i1][i2];
                                if (i2 == v2 + w2) pt2 = pt2 + p[j][i][i1][i2];
                            }
                        }
                    }
                }

                //{intensities of blocked  (rb)  and coming (rt) calls on phases of servicing}
                rb = 0;
                rb1 = 0;
                rb2 = 0;
                rb11 = 0;
                rb22 = 0;
                rt = 0;
                rt1 = 0;
                rt2 = 0;

                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                if (i == v + w) rb = rb + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a;
                                rt = rt + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a;

                                if (i1 == v1 + w1) rb1 = rb1 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a1;
                                if (i1 == v1 + w1) rb11 = rb11 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a1;

                                if ((i <= v) && (i1 == v1 + w1)) rb1 = rb1 + p[j][i][i1][i2] * i * mu * c * c1;
                                if ((i > v) && (i1 == v1 + w1)) rb1 = rb1 + p[j][i][i1][i2] * v * mu * c * c1;
                                rt1 = rt1 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a1;
                                if (i <= v) rt1 = rt1 + p[j][i][i1][i2] * i * mu * c * c1;
                                if (i > v) rt1 = rt1 + p[j][i][i1][i2] * v * mu * c * c1;

                                if (i2 == v2 + w2) rb2 = rb2 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a2;
                                if (i2 == v2 + w2) rb22 = rb22 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a2;

                                if ((i <= v) && (i2 == v2 + w2)) rb2 = rb2 + p[j][i][i1][i2] * i * mu * c * c2;
                                if ((i > v) && (i2 == v2 + w2)) rb2 = rb2 + p[j][i][i1][i2] * v * mu * c * c2;
                                rt2 = rt2 + p[j][i][i1][i2] * (lambda * qp + j * nu * qr) * a2;
                                if (i <= v) rt2 = rt2 + p[j][i][i1][i2] * i * mu * c * c2;
                                if (i > v) rt2 = rt2 + p[j][i][i1][i2] * v * mu * c * c2;
                            }
                        }
                    }
                }

                delta = 0;
                //{delta keeps intensity of losses due to finite nature of rm}
                for (j = 0; j <= rm; j++) {
                    for (i = 0; i <= v + w; i++) {
                        for (i1 = 0; i1 <= v1 + w1; i1++) {
                            for (i2 = 0; i2 <= v2 + w2; i2++) {
                                if ((i == v + w) && (j == rm)) delta = delta + p[j][i][i1][i2] * lambda * h * qp * a;
                                if ((i1 == v1 + w1) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * lambda * h * qp * a1;
                                if ((i2 == v2 + w2) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * lambda * h * qp * a2;

                                if ((i + 1 <= v) && (i1 == v1 + w1) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * (i + 1) * mu * c * c1 * h;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i1 == v1 + w1) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * v * mu * c * c1 * h;

                                if ((i + 1 <= v) && (i2 == v2 + w2) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * (i + 1) * mu * c * c2 * h;
                                if ((i + 1 <= v + w) && (i + 1 > v) && (i2 == v2 + w2) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * v * mu * c * c2 * h;

                                if ((i + 1 <= v + w) && (i + 1 > v) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * (i + 1 - v) * sigma * h;

                                if ((i1 + 1 <= v1 + w1) && (i1 + 1 > v1) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * (i1 + 1 - v1) * sigma1 * h;
                                if ((i2 + 1 <= v2 + w2) && (i2 + 1 > v2) && (j == rm))
                                    delta = delta + p[j][i][i1][i2] * (i2 + 1 - v2) * sigma2 * h;
                            }
                        }
                    }
                }

                //   {the ratio of blocked calls (pc) on phases of servicing}
                pc = (rb + mw * sigma) / rt;
                pc1 = (rb1 + mw1 * sigma1) / rt1;
                pc2 = (rb2 + mw2 * sigma2) / rt2;

                //  {the mean time of waiting or servicing (tw) on phases of servicing}
                tw = (mi + mw) / (rt - rb);
                tw1 = (mi1 + mw1) / (rt1 - rb1);
                tw2 = (mi2 + mw2) / (rt2 - rb2);

                //   {global measures of calls servicing}
                pct = (rb + mw * sigma + rb1 + mw1 * sigma1 + rb2 + mw2 * sigma2) / (lambda * qp + mr * nu * qr);
                twt = (mi + mw + mi1 + mw1 + mi2 + mw2) / (lambda * qp + mr * nu * qr - rb - rb11 - rb22);
                mwt = mw + mw1 + mw2;
                mit = mi + mi1 + mi2;
                mrp = mr * nu / lambda;
                q = (rb + mw * sigma + rb1 + mw1 * sigma1 + rb2 + mw2 * sigma2) / (mi * mu * (1 - c) + mi1 * mu1 + mi2 * mu2);

                //   {checking of the validity of relations based on Little formula for each component of the state vector
                //   (it is supposed that rm finite if not then delta=0)}
                dif = mr * nu - (rb + mw * sigma) * h - (rb1 + mw1 * sigma1) * h - (rb2 + mw2 * sigma2) * h;
                dif1 = mr * nu - (rb + mw * sigma) * h - (rb1 + mw1 * sigma1) * h - (rb2 + mw2 * sigma2) * h + delta;
                dif2 = rt - rb - mw * sigma - mi * mu;
                dif3 = rt1 - rb1 - mw1 * sigma1 - mi1 * mu1;
                dif4 = rt2 - rb2 - mw2 * sigma2 - mi2 * mu2;

                System.out.println("���� ������������� �������� =" + pct);
                System.out.println("������� ����� ������������ � �������=" + twt);
                //System.out.println(""+mwt);
                System.out.println("������� ���������� �������� �� ������������ =" + mit);
                System.out.println("���� ���������� ��������, ���������� �� ����������" + pc);
                System.out.println("C������ ���������� ������� ���������� = " + mi);
                System.out.println("������� ����� ���������� � �������, ��������� " + tw);

                System.out.println("���� ������������� ��������, 1= " + pc1);
                System.out.println("������� ����� ���������� � �������, 1 =" + tw1);
                //System.out.println("mw1="+mw1);
                System.out.println("������� ���������� �������, 1 = " + mi1);

                System.out.println("���� ������������� ��������, 2= " + pc2);
                System.out.println("������� ����� ���������� � �������, 2 = " + tw2);
                //System.out.println("mw2="+mw2);
                System.out.println("������� ���������� �������, 2 = " + mi2);

                // System.out.println("mr="+mr);
                // System.out.println("mrp="+(mr*nu/lambda));
                // System.out.println("nu="+nu);
                // System.out.println("Int="+(lambda+mr*nu));
                //System.out.println("pct="+pct);
                // System.out.println("pc="+pc);
                // System.out.println("pc1="+pc1);
                // System.out.println("pc2="+pc2);
                // System.out.println("twt="+twt);
                // System.out.println("mr="+mr);
                // System.out.println("mrp="+mrp);
                // System.out.println("q="+q);
                // System.out.println("delta="+delta);
                // System.out.println("rm="+rm);

                String out = String.valueOf(pct);
                textField_8.setText(out.substring(0, 8));

                String out1 = String.valueOf(twt);
                textField_9.setText(out1.substring(0, 8));

                String out2 = String.valueOf(mi + mi1 + mi2);
                textField_10.setText(out2.substring(0, 8));

                String out3 = String.valueOf(pc1);
                textField_11.setText(out3.substring(0, 8));

                String out4 = String.valueOf(pc);
                textField_12.setText(out4.substring(0, 8));

                String out5 = String.valueOf(pc2);
                textField_13.setText(out5.substring(0, 8));

                String out6 = String.valueOf(mi);
                textField_14.setText(out6.substring(0, 8));

                String out7 = String.valueOf(mi1);
                textField_15.setText(out7.substring(0, 8));

                String out8 = String.valueOf(mi2);
                textField_16.setText(out8.substring(0, 8));

                String out9 = String.valueOf(tw);
                textField_17.setText(out9.substring(0, 8));

                String out10 = String.valueOf(tw1);
                textField_18.setText(out10.substring(0, 8));

                String out11 = String.valueOf(tw2);
                textField_19.setText(out11.substring(0, 8));
            }
            return true;
        }
    }
}
