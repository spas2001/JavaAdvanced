package calc_oop_test.operations;

/**
 * @author  Булгаков В.В.
 * Интерфейс математическoй операции остатка от деления
 */

public class OperationMod implements Operation {

    @Override
    public double calculate(double a, double b) {
        if (b != 0) {
            return a % b;
        } else {
            System.out.println("Division by zero");
            return 0;
        }
    }
}
