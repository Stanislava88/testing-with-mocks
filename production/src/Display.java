import java.text.DecimalFormat;

/**
 * Created by clouway on 15-8-6.
 */
public class Display {
    String text = "";
    DecimalFormat df = new DecimalFormat("#0.00");

    public String getText() {
        return text;
    }

    public void productIsAccepted(String name, Double quantity, Double price) {
        text = (quantity + " bottles of " + name + " are accepted in warehouse at price of " + df.format(price));
    }

    public void toMuchQuantityToAccept(String name, Double quantity) {
        text = (quantity + " bottles of " + name + " are to much");
    }

    public void noNameOrQuantityAndPriceAreInvalid() {
        text = ("The product has not name, or quantity and price are invalid ");
    }

    public void canNotToAccept() {
        text = ("This product can not accepted in this warehouse");
    }

    public void missingNameOrQuantity() {
        text = ("Selling error: missing name or quantity");
    }

    public void displayProductIsSell(Double price, Double quantity) {
        text = (df.format(price * quantity));
    }

    public void displayNotEnoughProducts(String name) {
        text = ("Warehouse are not enough " + name);
    }

    public void displayProductIsNotFound(String name) {
        text = ("Product " + name + " is not found");
    }
}