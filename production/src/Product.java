/**
 * Created by clouway on 15-8-5.
 */
public class Product {
    private double price;
    private String name;
    private double quantity;
    private final double maxQuantity;

    public Product(String name, double price, double quantity, double maxQuantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }


    public String getName() {
        return name;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity += quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
