package ru.shishkin.maxim.emergencyService;

public class GetCalculation {
    // Расчет доли потерянных голосовых запросов и запросов в виде файлов в зависимости от входящей интенсивности
    public void getcalculationL() {
        for (int i = 20; i <= 40; i += 2) {
            Calculation calculation = new Calculation();

            // Вероятность запроса на обслуживание голосом
            calculation.setPv(0.7);
            // Вероятность запроса на обслуживание файлом
            calculation.setPf(0.3);
            // Вероятноссть обслуживания IVR или ЧатБот
            calculation.setPr(0.8);

            // Интенсивность входящих запросов на обслуживание
            calculation.setL(i);
            // Интенсивности обслуживания заявок
            calculation.setAlfa(1);
            // Время прибывания в очереди ожидания
            calculation.setSigma(0.1);

            // Операторы
            calculation.setV(10);
            // Общее число мест ожиданий
            calculation.setW(5);

            // Вычисления и получение результата
            calculation.getResault();

            // System.out.println(i + " " + calculation.convertVariable(calculation.getPv()) + " " + calculation.convertVariable(calculation.getPf()));
            // System.out.print(calculation.convertVariable(calculation.getPv()) + ", ");
            System.out.print(calculation.convertVariable(calculation.getPf()) + ", ");
        }
    }

    // Расчет доли потерянных голосовых запросов и запросов в виде файлов в зависимости от количества операторов
    public void getcalculationV() {
        for (int i = 1; i <= 9; i++) {
            Calculation calculation = new Calculation();

            // Вероятность запроса на обслуживание голосом
            calculation.setPv(0.7);
            // Вероятность запроса на обслуживание файлом
            calculation.setPf(0.3);
            // Вероятноссть обслуживания IVR или ЧатБот
            calculation.setPr(0.8);

            // Интенсивность входящих запросов на обслуживание
            calculation.setL(12);
            // Интенсивности обслуживания заявок
            calculation.setAlfa(1);
            // Время прибывания в очереди ожидания
            calculation.setSigma(0.1);

            // Операторы
            calculation.setV(i);
            // Общее число мест ожиданий
            calculation.setW(5);

            // Вычисления и получение результата
            calculation.getResault();

            // System.out.println(i + " " + calculation.convertVariable(calculation.getPv()) + " " + calculation.convertVariable(calculation.getPf()));
            // System.out.print(calculation.convertVariable(calculation.getPv()) + ", ");
            System.out.print(calculation.convertVariable(calculation.getPf()) + ", ");
        }
    }
}
