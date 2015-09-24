/**
 * Created by clouway on 15-8-5.
 */
public class WareHouse {
    private Display display;
    private Catalog catalog;

    public WareHouse(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void sell(String productName, Double quantity) {
        if ("".equals(productName) || quantity <= 0) {
            display.missingNameOrQuantity();
            return;
        }
        Product product = catalog.findProduct(productName);
        if (product != null) {
            if (quantity <= product.getQuantity()) {
                display.displayProductIsSell(product.getPrice(), quantity);
                product.setQuantity(-quantity);
            } else {
                display.displayNotEnoughProducts(productName);
            }
        } else {
            display.displayProductIsNotFound(productName);
        }
    }

    public void addProduct(String productName, Double quantity, Double price) {
        if ("".equals(productName) || price <= 0 || quantity <= 0) {
            display.noNameOrQuantityAndPriceAreInvalid();
            return;
        }
        Product product = catalog.findProduct(productName);
        if (product != null) {
            if (product.getMaxQuantity() >= product.getQuantity() + quantity) {
                product.setQuantity(quantity);
                product.setPrice(price);
                display.productIsAccepted(productName, quantity, price);
            } else {
                display.toMuchQuantityToAccept(productName, quantity);
            }
        } else {
            display.canNotToAccept();
        }
    }
}