package calc_oop_new.operations;

public class OperationMinus extends Operation {
    @Override
    public double calculate(double a, double b) {

        double result = a - b;
        return result;
    }
}
