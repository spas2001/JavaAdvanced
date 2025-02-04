package Sweet;


public class JellyBean extends SweetItem {
    private String hard;

    public JellyBean() {
        super("noname", 0, 0);
        this.hard ="";
    }

    public JellyBean(String brand, double weight, double price, String hard) {
        super(brand, weight, price);
        this.hard = hard;
    }

    public String getHard() {
        return hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    @Override
    public String toString() {
        return "JellyBean {" + super.toString() +
                " hard='" + hard + '\'' +
                '}';
    }
}