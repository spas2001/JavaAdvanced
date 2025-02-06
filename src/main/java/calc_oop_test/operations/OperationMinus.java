package calc_oop_test.operations;

/**
 * @author  Булгаков В.В.
 * Интерфейс математическoй операции вычитания
 */

public class OperationMinus implements Operation {

    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}
