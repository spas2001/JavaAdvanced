package calc_oop_new.operations;

public class OperationMod extends Operation {
    @Override
    public double calculate(double a, double b) {

            double result = a % b;
            return result;

    }
}
