package ru.shishkin.maxim.emergencyService;

public class GetCalculation {
    // Расчет доли потерянных голосовых запросов и запросов в виде файлов в зависимости от входящей интенсивности
    public void getcalculationL() {
        for (int i = 10; i <= 63; i++) {
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
            calculation.setAlfa(4);
            // Время прибывания в очереди ожидания
            calculation.setSigma(3);

            // Операторы
            calculation.setV(10);
            // Общее число мест ожиданий
            calculation.setW(5);

            // Вычисления и получение результата
            calculation.getResault();

            System.out.println(i + " " + calculation.convertVariable(calculation.getPv()) + " " + calculation.convertVariable(calculation.getPf()));
            // System.out.println(calculation.convertVariable(calculation.getPv()));
            // System.out.println(calculation.convertVariable(calculation.getPf()));
        }
    }

    // Расчет доли потерянных голосовых запросов и запросов в виде файлов в зависимости от количества операторов
    public void getcalculationV() {
        for (int i = 8; i <= 13; i++) {
            Calculation calculation = new Calculation();

            // Вероятность запроса на обслуживание голосом
            calculation.setPv(0.7);
            // Вероятность запроса на обслуживание файлом
            calculation.setPf(0.3);
            // Вероятноссть обслуживания IVR или ЧатБот
            calculation.setPr(0.8);

            // Интенсивность входящих запросов на обслуживание
            calculation.setL(30);
            // Интенсивности обслуживания заявок
            calculation.setAlfa(4);
            // Время прибывания в очереди ожидания
            calculation.setSigma(3);

            // Операторы
            calculation.setV(i);
            // Общее число мест ожиданий
            calculation.setW(5);

            // Вычисления и получение результата
            calculation.getResault();
            // System.out.println(i + " " + calculation.convertVariable(calculation.getPv()) + " " + calculation.convertVariable(calculation.getPf()));
            //System.out.println(calculation.convertVariable(calculation.getPv()));
            System.out.println(calculation.convertVariable(calculation.getPf()));
        }
    }
}
