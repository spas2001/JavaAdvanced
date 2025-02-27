package calc_oop_new.operations;

public class OperationSum extends Operation {
    public OperationSum(double a, double b) {
        super(a,b);
    }
    @Override
    public double calculate(double a, double b) {
        double result = a + b;
        return result;

    }
}
