package calc_oop_new;

import calc_oop_new.operations.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Java Advanced Example #4
 *
 * @author Булгаков В.В. 27.02.2025
 * 1. Реализовать калькулятор с использованием принципов ООП
 * При наследовании класса мы можем перекрывать методы в наследниках
 * @see calc_oop_new.operations.Operation
 * 2. Добавить обработку исключений в задание с ООП калькулятора (например, исключение может возникнуть при делении на ноль)
 */
public class OOPMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalcGetValue cgl = new CalcGetValue(sc);
        Operation op;
        double ldRes = 0, ldVar1, ldVar2;
        String lsOper = "";
        try {
            ldVar1 = cgl.GetInputDouble("Введите значение первой переменной: ");
            ldVar2 = cgl.GetInputDouble("Введите значение второй переменной: ");
            lsOper = cgl.GetInputString("Введите арифметическую операцию (+,-,/,*,%): ");
            //Закрываем поток ввода
            sc.close();
            CalcOOP calc = new CalcOOP(ldVar1, ldVar2, lsOper);
            //Вычисляем
            ldRes = calc.getResult();
            System.out.printf("\nРезультат: %.4f", ldRes);
        } catch (InputMismatchException im) {
            System.out.println("Некорректный параметр");
            im.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Некорректное завершение программы");
            e.printStackTrace();
            ldRes = Double.NaN;
        }
    }
}
