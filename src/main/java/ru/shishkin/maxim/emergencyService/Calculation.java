package ru.shishkin.maxim.emergencyService;

public class Calculation {
    // Входные параметры
    // Интенсивность поступления заявок v - voice
    private double Lv;
    // Интенсивность поступления заявок f - file
    private double Lf;
    // Интенсивности обслуживания заявок
    private double alfa;
    // Время прибывания в очереди ожидания
    private double sigma;
    // Операторы
    private int v;
    // Общее число мест ожиданий
    private int w;
    // Вероятность запроса на обслуживание голосом
    private double Pv;
    // Вероятность запроса на обслуживание файлом
    private double Pf;
    // Вероятноссть обслуживания голосом после IVR или ЧатБот
    private double Pr;


    private void getResault() {
        double eps = 0.0000000001;
        double P[] = new double[(int) (v + w + 1)];
        String rezultat = "";

        int noi = 1;
        double ncc = 1;
        double ncp;
        double Pleft = 0;
        double Pright = 0;
        double dif;

        for (int i = 0; i <= v + w; i++) {
            P[i] = 1;
        }

        do {
            ncp = ncc;
            ncc = 0;

            for (int i = 0; i <= v + w; i++) {
                if (i < v) Pleft = Pleft + Lv * Pr;
                if (i < v + w) Pleft = Pleft + Lf;
                if (i > 0 && i <= v) Pleft = Pleft + i * alfa;
                if (i > v && i <= v + w) Pleft = Pleft + v * alfa;
                if (i > v && i <= v + w) Pleft = Pleft + sigma * (i - v);


                if (i <= v) Pright = Pright + P[i - 1] * Lv * Pr;
                if (i > 0) Pright = Pright + P[i - 1] * Lf;
                if (i < v) Pright = Pright + P[i + 1] * (i + 1) * alfa;
                if (v <= i && i <= v + w) Pright = Pright + P[i + 1] * v * alfa;
                if (v <= i && i <= v + w) Pright = Pright + P[i + 1] * (i + 1 - v) * sigma;

                P[i] = Pright / Pleft;
                ncc = ncc + P[i];
            }

            noi++;
            dif = Math.abs(ncc - ncp) / ncc;
        } while (dif > eps && noi < 1000);

        for (int i = 0; i <= v + w; i++) {
            P[i] = P[i] / ncc;
            rezultat = rezultat + "P(" + i + ")=" + P[i] + "\n";
            System.out.println("P(" + i + ")=" + P[i]);
        }

        double p = 0;


        for (int i = 0; i <= v + w; i++) {
            if (i == v) p = P[i];
            if (i > 0) m = m + P[i] * i;
        }

        dif = lymbda - lymbda * p - m * mu;
        rezultat = rezultat + "Доля потерянных заявок: " + "\n";
        rezultat = rezultat + "" + p + "\n";
        rezultat = rezultat + "Среднее количество занятых операторов: " + "\n";
        rezultat = rezultat + "" + m + "\n";


        // Доля потерянных голосовых запросов
        double PIv = 0;
        for (int i = v; i <= v + w; i++) {
            PIv = PIv + P[i];
        }
        System.out.println("PIv = " + PIv);

        // Доля потерянных запросов в форме файлов
        double PIf = 0;
        int j = 1;
        for (int i = v + 1; i <= v + w; i++) {
            PIf = PIf + P[i] * j;
            j++;
        }
        PIf = PIf * sigma / Lf + P[v + w];
        System.out.println("PIf = " + PIf);

        // Величина среднего числа занятых операторов
        double m = 0, m2 = 0;
        for (int i = 1; i <= v; i++) {
            m = m + P[i] * i;
        }
        for (int i = v + 1; i <= v + w; i++) {
            m2 = m2 + P[i];
        }
        m = m + v * m2;
        System.out.println("m = " + m);

        // Величина среднего числа операторов, занятых обслуживанием голосовых запросов
        double mv = 0;
        mv = (Lv * Pr * (1 - PIv)) / alfa;
        System.out.println("mv = " + mv);

        // Величина среднего числа операторов, занятых обслуживанием файлов
        double mf = 0;
        mf = m - mv;
        System.out.println("mf = " + mf);

        // Величина среднего числа файлов, находящихся в ожидании
        double wf = 0;
        for (int i = v + 1; i <= v + w; i++) {
            wf = wf + P[i] * (i - v);
        }
        System.out.println("wf = " + wf);

        // Величина среднего времени нахождения файла в ожидании
        double tw = 0;
        for (int i = v; i <= v + w - 1; i++) {
            tw = tw + P[i];
        }
        tw = wf / (Lf * tw);
        System.out.println("tw = " + tw);
    }
}
