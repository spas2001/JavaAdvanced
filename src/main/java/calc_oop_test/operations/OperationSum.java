package calc_oop_test.operations;

/**
 * @author Булгаков В.В.
 * Интерфейс математическoй операции сложения
 */
public class OperationSum implements Operation {

    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}
