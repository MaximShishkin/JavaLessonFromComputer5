package ru.shishkin.maxim.emergencyService;

import java.text.DecimalFormat;

public class Calculation {
    // Входные параметры
    // Вероятность запроса на обслуживание голосом
    private double Pv = 0.8; // 0.8
    // Вероятность запроса на обслуживание файлом
    private double Pf = 0.2; //
    // Вероятноссть обслуживания IVR или ЧатБот
    private double Pr = 0.8;
    // Интенсивность входящих запросов на обслуживание
    private double L = 5;
    // Интенсивность поступления заявок v - voice
    private double Lv = L * Pv;
    // Интенсивность поступления заявок f - file
    private double Lf = L * Pf;
    // Интенсивности обслуживания заявок
    private double alfa = 4;
    // Время прибывания в очереди ожидания
    private double sigma = 2;
    // Операторы
    private int v = 5;
    // Общее число мест ожиданий
    private int w = 5;

    private int len = 8;
    //
    String resault = "";

    protected void getResault() {
        // Точность
        double eps = 0.0000000001;
        // Массив с вероятностями
        double P[] = new double[(int) (v + w + 1)];
        int noi = 1;
        double ncc = 1;
        double ncp;
        //
        double left;
        //
        double right;
        double dif;
        // Доля потерянных голосовых запросов
        double pv = 0;
        // Доля потерянных запросов в форме файлов
        double pf = 0;
        int j = 1;
        // Величина среднего числа занятых операторов
        double m = 0, m2 = 0;
        // Величина среднего числа операторов, занятых обслуживанием голосовых запросов
        double mv = 0;
        // Величина среднего числа операторов, занятых обслуживанием файлов
        double mf = 0;
        // Величина среднего числа файлов, находящихся в ожидании
        double wf = 0;
        // Величина среднего времени нахождения файла в ожидании
        double tw = 0;

        for (int i = 0; i <= v + w; i++) {
            P[i] = 1;
        }

        do {
            ncp = ncc;
            ncc = 0;

            for (int i = 0; i <= v + w; i++) {
                left = 0;
                if (i < v) left = left + Lv * Pr;
                if (i < v + w) left = left + Lf;
                if (i > 0 && i <= v) left = left + i * alfa;
                if (i > v && i <= v + w) left = left + v * alfa;
                if (i > v && i <= v + w) left = left + sigma * (i - v);

                right = 0;
                if (i > 0 && i <= v) right = right + P[i - 1] * Lv * Pr;
                if (i > 0) right = right + P[i - 1] * Lf;
                if (i < v) right = right + P[i + 1] * (i + 1) * alfa;
                if (i >= v && i < v + w) right = right + P[i + 1] * (v * alfa + (i + 1 - v) * sigma);

                P[i] = right / left;
                ncc = ncc + P[i];
            }

            noi++;
            dif = Math.abs(ncc - ncp) / ncc;
        } while (dif > eps && noi < 1000);

        for (int i = 0; i <= v + w; i++) {
            P[i] = P[i] / ncc;
            resault = resault + "P(" + i + ")=" + P[i] + "\n";
            System.out.println("P(" + i + ")=" + P[i]);
        }

        // Доля потерянных голосовых запросов
        for (int i = v; i <= v + w; i++) {
            pv = pv + P[i];
        }

        resault += "Доля потерянных голосовых запросов pv = " + "\n";
        resault += new DecimalFormat(pattern).format(pv).replace(',', '.') + "\n";

        // Доля потерянных запросов в форме файлов
        for (int i = v + 1; i <= v + w; i++) {
            pf = pf + P[i] * j;
            j++;
        }

        pf = pf * sigma / Lf + P[v + w];

        resault += "Доля потерянных запросов в форме файлов pf = " + "\n";
        resault += new DecimalFormat(pattern).format(pf).replace(',', '.') + "\n";

        // Величина среднего числа занятых операторов
        for (int i = 1; i <= v; i++) {
            m = m + P[i] * i;
        }

        for (int i = v + 1; i <= v + w; i++) {
            m2 = m2 + P[i];
        }

        m = m + v * m2;

        resault += "Величина среднего числа занятых операторов m = " + "\n";
        resault += new DecimalFormat(pattern).format(m).replace(',', '.') + "\n";

        // Величина среднего числа операторов, занятых обслуживанием голосовых запросов
        mv = (Lv * Pr * (1 - pv)) / alfa;
        resault += "Величина среднего числа операторов, занятых обслуживанием голосовых запросов mv = " + "\n";
        resault += new DecimalFormat(pattern).format(mv).replace(',', '.') + "\n";

        // Величина среднего числа операторов, занятых обслуживанием файлов
        mf = m - mv;
        resault += "Величина среднего числа операторов, занятых обслуживанием файлов mf = " + "\n";
        resault += new DecimalFormat(pattern).format(mf).replace(',', '.') + "\n";

        // Величина среднего числа файлов, находящихся в ожидании
        for (int i = v + 1; i <= v + w; i++) {
            wf = wf + P[i] * (i - v);
        }
        resault += "Величина среднего числа файлов, находящихся в ожидании wf = " + "\n";
        resault += converVariable(wf) + "\n";

        // Величина среднего времени нахождения файла в ожидании
        for (int i = v; i <= v + w - 1; i++) {
            tw = tw + P[i];
        }

        tw = wf / (Lf * tw);

        resault += "Величина среднего времени нахождения файла в ожидании tw = " + "\n";
        resault += converVariable(tw) + "\n";
    }

    private String converVariable(double variable) {
        return new DecimalFormat("#0.00000000").format(variable).replace(',', '.');
    }
}