package calc_oop_new.operations;

public class OperationDiv extends Operation {

    public OperationDiv(double a, double b) {
        super(a,b);
    }

    @Override
    public double calculate(double a, double b) {
        if( b == 0 ) {
            throw new ArithmeticException("Деление на 0!");
        }
        double result = a / b;
        return result;

    }
}
