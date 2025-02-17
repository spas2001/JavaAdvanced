package calc_oop_new;

import calc_oop_new.operations.*;

import java.util.Scanner;

/**
 * Java Advanced Example #4 and #6
 *
 * @author Булгаков В.В. 12.02.2025
 * 1. Реализовать калькулятор с использованием принципов ООП
 * При наследовании класса мы можем перекрывать методы в наследниках
 * @see calc_oop_new.operations.Operation
 * 2. Добавить обработку исключений в задание с ООП калькулятора (например, исключение может возникнуть при делении на ноль)
 */

public class CalcOOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double ldRes = 0, ldVar1, ldVar2;
        Operation op = new Operation();
        if (op.opInit(sc) < 0) {
            return;
        }
        ldVar1 = op.getLdVar1();
        ldVar2 = op.getLdVar2();
        Operation op1;
        switch (op.getOper()) {
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
                throw new IllegalStateException("Unexpected value: " + op.getOper());
        }
        try {
            ldRes = op1.calculate(ldVar1, ldVar2);
            //Результат NaN и Infinity не порождает у меня исключения (программа устойчиво работает) пришлось сделать исключения принудительно
//            if (Double.isNaN(ldRes)) {
//                throw (new Exception("NAN"));
//            } else if (Double.isInfinite(ldRes)) {
//                throw (new Exception("INFINITE"));
//            }
            System.out.printf("\nРезультат: %.4f", ldRes);
        } catch (Exception e) {
            e.printStackTrace();
            ldRes = Double.NaN;
        } finally {
            sc.close();
        }
    }
}
