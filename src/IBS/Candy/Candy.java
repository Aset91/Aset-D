package IBS.Candy;

public abstract class Candy {

    private String name;
    private double weight;
    private double price;
    private String shape;

    public Candy(String name, double weight, double price, String shape) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.shape = shape;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getShape() {
        return shape;
    }
}
