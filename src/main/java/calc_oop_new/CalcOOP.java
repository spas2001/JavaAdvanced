package calc_oop_new;

import calc_oop_new.operations.*;


public class CalcOOP {
    private double ldVar1, ldVar2;
    private String lsOper;
    private double result;

    public CalcOOP(double ldVar1, double ldVar2, String lsOper) {
        this.ldVar1 = ldVar1;
        this.ldVar2 = ldVar2;
        this.lsOper = lsOper;
        this.result = calc();
    }

    public double calc() {
        Operation op;
        switch (lsOper) {
            case "+":
                op = new OperationSum(ldVar1, ldVar2);
                break;
            case "-":
                op = new OperationMinus(ldVar1, ldVar2);
                break;
            case "*":
                op = new OperationMulti(ldVar1, ldVar2);
                break;
            case "/":
                op = new OperationDiv(ldVar1, ldVar2);
                break;
            case "%":
                op = new OperationMod(ldVar1, ldVar2);
                break;
            default:
                throw new IllegalStateException("Некорректное значение операции ");
        }
        //Вычисляем
        return this.result = op.getResult();
    }

    public void setLdVar1(double ldVar1) {
        this.ldVar1 = ldVar1;
    }

    public void setLdVar2(double ldVar2) {
        this.ldVar2 = ldVar2;
    }

    public void setLsOper(String lsOper) {
        this.lsOper = lsOper;
    }

    public double getResult() {
        return this.result;
    }
}
