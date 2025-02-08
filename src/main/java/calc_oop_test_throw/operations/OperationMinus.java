package calc_oop_test_throw.operations;

/**
 * @author  Булгаков В.В.
 * Интерфейс математическoй операции вычитания
 */

public class OperationMinus implements Operation {

    @Override
    public double calculate(double a, double b) throws Exception {
        return a - b;
    }
}
