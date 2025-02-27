package calc_oop_new.operations;

public class OperationMod extends Operation {
    public OperationMod(double a, double b) {
        super(a,b);
    }
    @Override
    public double calculate(double a, double b) {
        if( b == 0 ) {
            throw new ArithmeticException("Деление на 0!");
        }
        return a % b;

    }
}
