import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by clouway on 15-8-6.
 */
public class TestAddProduct {
    Product cola = new Product("cola", 2.30, 10, 30);
    Product soda = new Product("soda", 1.30, 6, 50);
    Product sprite = new Product("sprite", 2.10, 15, 30);
    Product juice = new Product("juice", 3.00, 20, 30);
    Map<String, Product> productByName = new HashMap<String, Product>() {{
        put(cola.getName(), cola);
        put(soda.getName(), soda);
        put(sprite.getName(), sprite);
        put(juice.getName(), juice);
    }};
    Catalog catalog=new Catalog(productByName);
    Display display = new Display();
    WareHouse warehouse = new WareHouse(display, catalog);

    @Test
    public void addProductWhichCan() {
        assertAddProduct("cola", 20.0, 2.30, "20.0 bottles of cola are accepted in warehouse at price of 2.30");
    }

    @Test
    public void addAnotherProductWhichCan() {
        assertAddProduct("soda", 24.0, 1.30, "24.0 bottles of soda are accepted in warehouse at price of 1.30");
    }

    @Test
    public void addProductWhichCanNot() {
        assertAddProduct("boza", 24.0, 1.30, "This product can not accepted in this warehouse");
    }

    @Test
    public void addProductWithoutName() {
        assertAddProduct("", 24.0, 1.30, "The product has not name, or quantity and price are invalid ");
    }

    @Test
    public void addProductWithZeroOrNegativePrise() {
        assertAddProduct("cola", 20.0, 0.0, "The product has not name, or quantity and price are invalid ");
    }

    @Test
    public void addProductWithZeroOrNegativeQuantity() {
        assertAddProduct("soda", 0.0, 1.30, "The product has not name, or quantity and price are invalid ");
    }

    @Test
    public void addToMuchQuantity() {
        assertAddProduct("soda", 45.0, 1.30, "45.0 bottles of soda are to much");
    }

    private void assertAddProduct(String product, double quantity, double price, String actual) {
        warehouse.addProduct(product, quantity, price);
        assertThat(actual, is(equalTo(display.getText())));
    }
}
