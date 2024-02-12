package ru.shishkin.maxim.emergencyService;

public class GetCalculation {
    // Расчет доли потерянных голосовых запросов и запросов в виде файлов в зависимости от входящей интенсивности
    public void getcalculationL() {
        Calculation calculation = new Calculation();

        for (int i = 20; i <= 30; i++) {
            // Вероятность запроса на обслуживание голосом
            calculation.setPv(0.7);
            // Вероятность запроса на обслуживание файлом
            calculation.setPf(0.3);
            // Вероятноссть обслуживания IVR или ЧатБот
            calculation.setPr(0.8);

            // Интенсивность входящих запросов на обслуживание
            calculation.setL(i);
            // Интенсивности обслуживания заявок
            calculation.setAlfa(4);
            // Время прибывания в очереди ожидания
            calculation.setSigma(3);

            // Операторы
            calculation.setV(10);
            // Общее число мест ожиданий
            calculation.setW(5);

            // Вычисления и получение результата
            calculation.getResault();

            // System.out.println(i + " " + calculation.convertVariable(calculation.getPv()) + " " +  calculation.convertVariable(calculation.getPf()));
            System.out.println(calculation.convertVariable(calculation.getPv()));
            // System.out.println(calculation.convertVariable(calculation.getPf()));
        }
    }

    public void getcalculationV() {
        Calculation calculation = new Calculation();

        for (int i = 1; i <= 50; i++) {
            // Вероятность запроса на обслуживание голосом
            calculation.setPv(0.8);
            // Вероятность запроса на обслуживание файлом
            calculation.setPf(0.2);
            // Вероятноссть обслуживания IVR или ЧатБот
            calculation.setPr(0.7);

            // Интенсивность входящих запросов на обслуживание
            calculation.setL(30);
            // Интенсивности обслуживания заявок
            calculation.setAlfa(5);
            // Время прибывания в очереди ожидания
            calculation.setSigma(3);

            // Операторы
            calculation.setV(i);
            // Общее число мест ожиданий
            calculation.setW(5);

            // Вычисления и получение результата
            calculation.getResault();
            // System.out.println(calculation.getResault());
        }
    }
}
