import java.util.Map;

/**
 * Catalog is an in-memory catalog which is holding all available products in the {@link WareHouse}
 *
 * @author Slavi Dichkof slavidichkof@gmail.com
 */
public class Catalog {
    private final Map<String, Product> productByName;

    public Catalog(Map<String, Product> productMap) {
        this.productByName = productMap;
    }

    public Product findProduct(String productName) {
        return productByName.get(productName);
    }
}
