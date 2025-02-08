package calc_oop_test_throw.operations;

/**
 * @author  Булгаков В.В.
 * Общий интерфейс математических операций
 */

public interface Operation {
    public double calculate(double a, double b) throws Exception;
}
