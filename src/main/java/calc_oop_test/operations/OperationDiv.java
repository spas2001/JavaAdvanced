package calc_oop_test.operations;
/**
 * @author  Булгаков В.В.
 * Интерфейс математическoй операции деления
 */
public class OperationDiv implements Operation {

    @Override
    public double calculate(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Division by zero");
            return 0;
        }
    }
}
