package calc_oop_new;

import java.util.Scanner;

public class CalcGetValue {
Scanner sc;
    public CalcGetValue() {
        sc = new Scanner(System.in);
    }

    public CalcGetValue(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Функция читает данные типа double
     *
     * @param prompt  Сообщение
     * @return значение переменной либо неопределенное значение при некорректном вводе
     */
    public double GetInputDouble(String prompt)  {
        //Сделаем отдельную функцию считывания с клавиатуры
        double ldRes;
        System.out.print(prompt);
        ldRes = this.sc.nextDouble();
        return ldRes;
    }

    /**
     * Функция считывает арифметическую операцию
     *
     * @param prompt  Сообщение
     * @return значение арифметической операции
     */
    public String GetInputString(String prompt) {
        String lsOperator;
        System.out.print(prompt);
         lsOperator = this.sc.next();
        return lsOperator;
    }
}
