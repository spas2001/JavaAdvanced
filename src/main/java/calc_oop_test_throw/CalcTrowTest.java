package calc_oop_test_throw;

import calc_oop_test_throw.operations.*;

import java.util.Scanner;

/**
 * Java Advanced Example #6
 *
 * @author Булгаков В.В. 08.02.2025
 * 1. Реализовать калькулятор с использованием принципов ООП
 * При использовании общего интерфейса мы можем использовать множественные классы с единым методом
 * При наследовании из абстрактного класса мы можем перекрывать методы в наследниках
 * Для данного примера продемонстрируем использование общего интерфейса
 * @see calc_oop_test_throw.operations.Operation
 *  2. Добавить обработку исключений в задание с ООП калькулятора (например, исключение может возникнуть при делении на ноль)
 */
public class CalcTrowTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ldVar1;
        double ldVar2;
        double ldRes = 0;
        try {
             ldVar1 = GetInputValue("Введите значение первой переменной: ", sc);
            if (Double.isNaN(ldVar1)) {
                System.out.println("Некорректное значение");
                return;
            }
        } catch (RuntimeException e) {
            System.out.println("Некорректное значение");
            e.getCause();
            e.getMessage();
            return;
        }
        try {
             ldVar2 = GetInputValue("Введите значение второй переменной: ", sc);
            if (Double.isNaN(ldVar2)) {
                System.out.println("Некорректное значение");
                return;
            }
        } catch (RuntimeException e) {
            System.out.println("Некорректное значение");
            e.getCause();
            e.getMessage();
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
                try {
                    ldRes = opSum.calculate(ldVar1, ldVar2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "-":
                Operation opMinus = new OperationMinus();
                try {
                    ldRes = opMinus.calculate(ldVar1, ldVar2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "*":
                Operation opMulti = new OperationMulti();
                try {
                    ldRes = opMulti.calculate(ldVar1, ldVar2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/":
                try {
                Operation opDiv = new OperationDiv();
                ldRes = opDiv.calculate(ldVar1, ldVar2);}
                catch (RuntimeException e) {
                    e.getCause();
                    e.getMessage();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "%":
                Operation opMod = new OperationMod();
                try {
                    ldRes = opMod.calculate(ldVar1, ldVar2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
