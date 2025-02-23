package calc_oop_new.operations;

public class OperationDiv extends Operation {

    public OperationDiv() {
    }

    @Override
    public double calculate(double a, double b) {

        double result = a / b;
        return result;

    }
}
