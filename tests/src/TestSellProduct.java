import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by clouway on 15-8-5.
 */
public class TestSellProduct {
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
    public void productFound() throws Exception {
        assertSell("cola", 1.0, "2.30");
    }

    @Test
    public void anotherProductFound() throws Exception {
        assertSell("soda", 1.0, "1.30");
    }

    @Test
    public void productIsNotFound() {
        assertSell("boza", 1.0, "Product boza is not found");
    }

    @Test
    public void missingName() {
        assertSell("", 1.0, "Selling error: missing name or quantity");
    }

    @Test
    public void missingQuantity() {
        assertSell("cola", 0.0, "Selling error: missing name or quantity");
    }

    @Test
    public void moreThanOneProduct() {
        assertSell("soda", 2.0, "2.60");
    }

    @Test
    public void moreThanOneProductWithDifrentQuantity() {
        assertSell("soda", 4.0, "5.20");
    }

    @Test
    public void noEenoughProductsInWareHous() {
        assertSell("soda", 8.0, "Warehouse are not enough soda");
    }
    private void assertSell(String product, double quantity, String actual) {
        warehouse.sell(product, quantity);
        assertThat(actual, is(equalTo(display.getText())));
    }
}