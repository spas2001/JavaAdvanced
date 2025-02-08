package calc_oop_test.operations;

/**
 * @author  Булгаков В.В.
 * Общий интерфейс математических операций
 */

public interface Operation {
    public double calculate(double ldVar1, double ldVar2) throws Exception;
}
