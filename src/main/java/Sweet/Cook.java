package Sweet;

public class Cook extends SweetItem {
    private String filling;

    public Cook() {
        super("noname", 0, 0);
        this.filling ="";
    }

    public Cook(String brand, double weight, double price, String filling) {
        super(brand, weight, price);
        this.filling = filling;
    }
    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "Cook {" + super.toString() +
                " filling='" + filling + '\'' +
                '}';
    }


}
