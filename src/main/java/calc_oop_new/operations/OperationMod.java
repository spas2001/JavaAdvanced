package calc_oop_new.operations;

public class OperationMod extends Operation {
    @Override
    public double calculate(double a, double b) {
        if( b == 0 ) {
            throw new ArithmeticException("Деление на 0!");
        }
            double result = a % b;
            return result;

    }
}
