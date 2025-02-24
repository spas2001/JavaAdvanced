package calc_oop_new;

import calc_oop_new.operations.*;

import java.util.InputMismatchException;


/**
 * Java Advanced Example #4 and #6
 *
 * @author Булгаков В.В. 20.02.2025
 * 1. Реализовать калькулятор с использованием принципов ООП
 * При наследовании класса мы можем перекрывать методы в наследниках
 * @see calc_oop_new.operations.Operation
 * 2. Добавить обработку исключений в задание с ООП калькулятора (например, исключение может возникнуть при делении на ноль)
 */

public class CalcOOP {
    public static void main(String[] args) {

        double ldRes = 0, ldVar1, ldVar2;
        String lsOper = "";
        Operation op = new Operation();

//        if (op.opInit(sc) < 0) {
//            return;
//        }
        try {
            ldVar1 = op.setVar("Введите значение первой переменной: ");
            ldVar2 = op.setVar("Введите значение второй переменной: ");
            Operation op1;
            lsOper = op.setOper();
            op.opCloseScan();
            switch (lsOper) {
                case "+":
                    op1 = new OperationSum();
                    break;
                case "-":
                    op1 = new OperationMinus();
                    break;
                case "*":
                    op1 = new OperationMulti();
                    break;
                case "/":
                    op1 = new OperationDiv();
                    break;
                case "%":
                    op1 = new OperationMod();
                    break;
                default:
                    throw new IllegalStateException("Некорректное значение операции ");
            }
            //Закрываем поток ввода
            op1.opCloseScan();
            //Вычисляем
            ldRes = op1.calculate(ldVar1, ldVar2);
            //Результат NaN и Infinity не порождает у меня исключения (программа устойчиво работает) пришлось сделать исключения принудительно
            if (Double.isNaN(ldRes)) {
                throw (new Exception("NAN"));
            } else if (Double.isInfinite(ldRes)) {
                throw (new Exception("INFINITE"));
            }

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
