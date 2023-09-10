/*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

package seminars.first.hw;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    public static void main(String[] args) {


        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product1", 10));
        products.add(new Product("Product2", 20));
        products.add(new Product("Product3", 30));
        shop.setProducts(products);


        // Проверка количества продуктов
        assertThat(shop.getProducts()).hasSize(3);

        // Проверка содержимого продуктов
        List<Product> storedProducts = shop.getProducts();
        assertThat(storedProducts)
                .hasSize(3)
                .extracting(Product::getTitle)
                .containsExactly("Product1", "Product2", "Product3");

        // Проверка сортировки по цене
        List<Product> sortedProducts = shop.getSortedListProducts();
        assertThat(sortedProducts)
                .hasSize(3)
                .extracting(Product::getTitle)
                .containsExactly("Product1", "Product2", "Product3");

        // Проверка возврата самого дорогого продукта
        Product mostExpensiveProduct = shop.getMostExpensiveProduct();
        assertThat(mostExpensiveProduct)
                .isNotNull()
                .extracting(Product::getTitle, Product::getCost)
                .containsExactly("Product3", 30);
    }
}




