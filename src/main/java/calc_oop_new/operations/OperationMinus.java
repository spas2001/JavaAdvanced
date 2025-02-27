package calc_oop_new.operations;

public class OperationMinus extends Operation {
    public OperationMinus(double a, double b) {
        super(a,b);
    }
    @Override
    public double calculate(double a, double b) {

        return a - b;
    }
}
