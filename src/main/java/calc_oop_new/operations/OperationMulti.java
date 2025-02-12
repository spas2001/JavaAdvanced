package calc_oop_new.operations;

public class OperationMulti extends Operation {
    @Override
    public double calculate(double a, double b) {
        try {
            double result = a * b;
            return result;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
            e.printStackTrace();
            return Double.NaN;
        } catch (Exception e) {
            System.out.println("Arithmetic Exception");
            e.printStackTrace();
        }
        return Double.NaN;
    }
}
