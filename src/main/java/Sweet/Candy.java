package Sweet;

public class Candy extends SweetItem {
    private String size;

    public Candy() {
        super("noname", 0, 0);
        this.size ="";
    }

    public Candy(String brand, double weight, double price, String size) {
        super(brand, weight, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Candy {" + super.toString() +
                " size='" + size + '\'' +
                '}';
    }
}
