package calc_oop_new.operations;


/**
 * @author Булгаков В.В.
 * Общий класс математических операций
 */
public class Operation {
    private double ldVar1, ldVar2;
    private String lsOper;
    private double result;


    public Operation() {

    }

    public Operation(double ldVar1, double ldVar2) {
        this.ldVar1 = ldVar1;
        this.ldVar2 = ldVar2;
        this.result = calculate(ldVar1, ldVar2);
    }

    public void setLdVar1(double ldVar1) {
        this.ldVar1 = ldVar1;
    }

    public void setLdVar2(double ldVar2) {
        this.ldVar2 = ldVar2;
    }

    public double getResult() {
        return this.result;
    }

    public double calculate(double a, double b) {

        return (double) 0;
    }


}
