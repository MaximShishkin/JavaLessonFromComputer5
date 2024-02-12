package ru.shishkin.maxim.emergencyService;

import java.text.DecimalFormat;

public class Calculation {
    // Входные параметры
    // Вероятность запроса на обслуживание голосом
    private double Pv;
    // Вероятность запроса на обслуживание файлом
    private double Pf;
    // Вероятноссть обслуживания после IVR или ЧатБот
    private double Pr;
    // Интенсивность входящих запросов на обслуживание
    private double L;
    // Интенсивности обслуживания заявок
    private double alfa;
    // Время прибывания в очереди ожидания
    private double sigma;
    // Операторы
    private int v;
    // Общее число мест ожиданий
    private int w;

    // Выходные параметры
    // Доля потерянных голосовых запросов
    private double pv;
    // Доля потерянных запросов в форме файлов
    private double pf;
    // Величина среднего числа занятых операторов
    private double m;
    // Величина среднего числа операторов, занятых обслуживанием голосовых запросов
    private double mv;
    // Величина среднего числа операторов, занятых обслуживанием файлов
    private double mf;
    // Величина среднего числа файлов, находящихся в ожидании
    private double wf;
    // Величина среднего времени нахождения файла в ожидании
    private double tw;

    public void setPv(double pv) {
        Pv = pv;
    }

    public void setPf(double pf) {
        Pf = pf;
    }

    public void setPr(double pr) {
        Pr = pr;
    }

    public void setL(double l) {
        L = l;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setW(int w) {
        this.w = w;
    }

    public double getPv() {
        return pv;
    }

    public double getPf() {
        return pf;
    }

    public double getM() {
        return m;
    }

    public double getMv() {
        return mv;
    }

    public double getMf() {
        return mf;
    }

    public double getWf() {
        return wf;
    }

    public double getTw() {
        return tw;
    }

    public String getResault() {
        // Интенсивность поступления заявок v - voice
        double Lv = L * Pv;
        // Интенсивность поступления заявок f - file
        double Lf = L * Pf;
        // Точность
        double eps;
        // Массив с вероятностями
        double P[] = new double[(int) (v + w + 1)];
        // Левая часть СУР
        double left;
        // Правая часть СУР
        double right;
        // Результат вычислений
        String resault;

        // Вспомагательные переменные
        int noi;
        double ncc;
        double ncp;
        double dif;
        double m2;

        for (int i = 0; i <= v + w; i++) {
            P[i] = 1;
        }

        noi = 1;
        ncc = 1;
        eps = 0.0000000001;

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

        resault = "";

        for (int i = 0; i <= v + w; i++) {
            P[i] = P[i] / ncc;
            resault = resault + "P(" + i + ")=" + convertVariable(P[i]) + "\n";
        }

        // Определение характеристик обслуживания запросов
        // Доля потерянных голосовых запросов
        for (int i = v; i <= v + w; i++) {
            pv = pv + P[i];
        }

        resault += "Доля потерянных голосовых запросов pv = " + "\n";
        resault += convertVariable(pv) + "\n";

        // Доля потерянных запросов в форме файлов
        noi = 1;
        pf = 0;

        for (int i = v + 1; i <= v + w; i++) {
            pf = pf + P[i] * noi;
            noi++;
        }

        pf = pf * sigma / Lf + P[v + w];

        resault += "Доля потерянных запросов в форме файлов pf = " + "\n";
        resault += convertVariable(pf) + "\n";

        // Величина среднего числа занятых операторов
        m = 0;
        m2 = 0;

        for (int i = 1; i <= v; i++) {
            m = m + P[i] * i;
        }

        for (int i = v + 1; i <= v + w; i++) {
            m2 = m2 + P[i];
        }

        m = m + v * m2;

        resault += "Величина среднего числа занятых операторов m = " + "\n";
        resault += convertVariable(m) + "\n";

        // Величина среднего числа операторов, занятых обслуживанием голосовых запросов
        mv = (Lv * Pr * (1 - pv)) / alfa;

        resault += "Величина среднего числа операторов, занятых обслуживанием голосовых запросов mv = " + "\n";
        resault += convertVariable(mv) + "\n";

        // Величина среднего числа операторов, занятых обслуживанием файлов
        mf = m - mv;

        resault += "Величина среднего числа операторов, занятых обслуживанием файлов mf = " + "\n";
        resault += convertVariable(mf) + "\n";

        // Величина среднего числа файлов, находящихся в ожидании
        wf = 0;

        for (int i = v + 1; i <= v + w; i++) {
            wf = wf + P[i] * (i - v);
        }

        resault += "Величина среднего числа файлов, находящихся в ожидании wf = " + "\n";
        resault += convertVariable(wf) + "\n";

        // Величина среднего времени нахождения файла в ожидании
        tw = 0;

        for (int i = v; i <= v + w - 1; i++) {
            tw = tw + P[i];
        }

        tw = wf / (Lf * tw);

        resault += "Величина среднего времени нахождения файла в ожидании tw = " + "\n";
        resault += convertVariable(tw) + "\n";

        return resault;
    }

    public String convertVariable(double variable) {
        return new DecimalFormat("#0.00000000").format(variable).replace(',', '.');
    }
}