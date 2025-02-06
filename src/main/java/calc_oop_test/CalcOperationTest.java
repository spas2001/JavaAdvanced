package calc_oop_test;

import calc_oop_test.operations.*;

import java.util.Scanner;

/**
 * Java Advanced Example #4
 *
 * @author Булгаков В.В. 06.02.2025
 * Реализовать калькулятор с использованием принципов ООП
 * При использовании общего интерфейса мы можем использовать множественные классы с единым методом
 * При наследовании из абстрактного класса мы можем перекрывать методы в наследниках
 * Для данного примера продемонстрируем использование общего интерфейса
 * @see calc_oop_test.operations.Operation
 */
public class CalcOperationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ldRes = 0;
        double ldVar1 = GetInputValue("Введите значение первой переменной: ", sc);
        if (Double.isNaN(ldVar1)) {
            System.out.println("Некорректное значение");
            return;
        }
        double ldVar2 = GetInputValue("Введите значение второй переменной: ", sc);
        if (Double.isNaN(ldVar2)) {
            System.out.println("Некорректное значение");
            return;
        }
        String lsOper = GetInputOperator("Введите арифметическую операцию (+,-,/,*,%): ", sc);
        if (lsOper.isEmpty()) {
            System.out.println("Некорректное значение");
            return;
        }
        switch (lsOper) {
            case "+":
                Operation opSum = new OperationSum();
                ldRes = opSum.calculate(ldVar1, ldVar2);
                break;
            case "-":
                Operation opMinus = new OperationMinus();
                ldRes = opMinus.calculate(ldVar1, ldVar2);
                break;
            case "*":
                Operation opMulti = new OperationMulti();
                ldRes = opMulti.calculate(ldVar1, ldVar2);
                break;
            case "/":
                Operation opDiv = new OperationDiv();
                ldRes = opDiv.calculate(ldVar1, ldVar2);
                break;
            case "%":
                Operation opMod = new OperationMod();
                ldRes = opMod.calculate(ldVar1, ldVar2);
                break;
        }
        System.out.printf("\nРезультат: %.4f", ldRes);
        sc.close();
    }

    /**
     * Функция читает данные типа double
     *
     * @param prompt  Сообщение
     * @param scanner поток ввода
     * @return значение переменной либо неопределенное значение при некорректном вводе
     */
    public static double GetInputValue(String prompt, Scanner scanner) {
        //Сделаем отдельную функцию считывания с клавиатуры
        double ldRes;
        System.out.print(prompt);
        if (scanner.hasNextDouble()) {
            ldRes = scanner.nextDouble();
        } else {
            ldRes = Double.NaN;
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
