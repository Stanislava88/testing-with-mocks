import java.util.Map;

/**
 * Created by clouway on 15-8-7.
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
