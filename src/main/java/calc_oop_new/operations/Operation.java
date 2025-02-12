package calc_oop_new.operations;

import java.util.Scanner;

/**
 * @author Булгаков В.В.
 * Общий класс математических операций
 */
public class Operation {
    private double ldVar1, ldVar2;
    private String lsOper;
    private Scanner sc;

    public Operation() {

    }

    public int opInit(Scanner sc) {
        this.sc = sc;
        if (setVar() < 0) {
            return -1;
        }
        if (setOper() < 0) {
            return -1;
        }
        return 0;
    }

    public int setVar() {

        try {
            this.ldVar1 = GetInputValue("Введите значение первой переменной: ", sc);
        } catch (RuntimeException e) {
            System.out.println("Некорректное значение первой переменной");
            e.getCause();
            e.getMessage();

            return -1;
        }

        try {
            this.ldVar2 = GetInputValue("Введите значение второй переменной: ", sc);
        } catch (RuntimeException e) {
            System.out.println("Некорректное значение второй переменной");
            e.getCause();
            e.getMessage();

            return -1;
        }

        return 0;
    }

    public int setOper() {

        this.lsOper = GetInputOperator("Введите арифметическую операцию (+,-,/,*,%): ", sc);
        if (lsOper.isEmpty()) {
            System.out.println("Некорректное значение");

            return -1;
        }

        return 0;
    }

    public String getOper() {
        return lsOper;
    }

    public double getLdVar1() {
        return ldVar1;
    }

    public double getLdVar2() {
        return ldVar2;
    }

    public double calculate(double a, double b) {

        return (double) 0;
    }

    /**
     * Функция читает данные типа double
     *
     * @param prompt  Сообщение
     * @param scanner поток ввода
     * @return значение переменной либо неопределенное значение при некорректном вводе
     */
    public double GetInputValue(String prompt, Scanner scanner) throws IllegalStateException {
        //Сделаем отдельную функцию считывания с клавиатуры
        double ldRes;
        System.out.print(prompt);
        try {
            ldRes = scanner.nextDouble();
        } catch (Exception e) {
            //System.out.println("Некорректное значение  переменной");
            e.getCause();
            e.getMessage();
            throw new IllegalStateException("Unexpected value: " );
        }
        return ldRes;
    }

    /**
     * Функция считывает арифметическую операцию
     *
     * @param prompt  Сообщение
     * @param scanner поток ввода
     * @return значение арифметической операции
     */
    public static String GetInputOperator(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String lsOperator = scanner.next();
        if ((lsOperator.length() != 1) || !(lsOperator.matches("[+-/*]+"))) {
            lsOperator = "";
        }
        return lsOperator;
    }
}
