package Sweet;

public abstract class SweetItem {
    private String brand;
    private double weight;
    private double price;
    private static int sweetCount;

    public SweetItem(String brand, double weight, double price) {
        this.brand = brand;
        this.weight = weight;
        this.price = price;
        sweetCount++; //Общее количество созданных экземпляров
    }

    public static int getSweetCount() {
        return sweetCount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "brand='" + brand + '\'' +
                ", weight=" + weight +
                ", price=" + price;

    }
}
