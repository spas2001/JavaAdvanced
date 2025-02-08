package calc_oop_test_throw.operations;

/**
 * @author Булгаков В.В.
 * Интерфейс математическoй операции деления
 */
public class OperationDiv implements Operation {

    @Override
    public double calculate(double a, double b) throws Exception {
        double c = Double.NaN;
        try {
            c = a / b;
            if(Double.isNaN(c)){
                throw(new Exception("NAN"));
            }
            else if(Double.isInfinite(c)){
                throw(new Exception("INFINITE"));
            }
        } catch (Exception e) {
            System.out.println("Ошибка операции деления ");
            e.printStackTrace();
            throw (new Exception("DIVERROR"));
        }
        return c;
    }
}
