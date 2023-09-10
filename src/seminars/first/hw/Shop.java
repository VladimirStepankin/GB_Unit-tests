package seminars.first.hw;

import java.util.List;
import java.util.ArrayList;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        List<Product> sortedProducts = new ArrayList<>(products);
        sortedProducts.sort((p1, p2) -> Double.compare(p1.getCost(), p2.getCost()));
        return sortedProducts;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null;
        }

        Product mostExpensiveProduct = products.get(0);
        for (Product product : products) {
            if (product.getCost() > mostExpensiveProduct.getCost()) {
                mostExpensiveProduct = product;
            }
        }

        return mostExpensiveProduct;
    }
}