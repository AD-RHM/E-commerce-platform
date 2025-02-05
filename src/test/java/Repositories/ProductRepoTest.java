package Repositories;

import Entities.Category;
import Entities.Product;
import Services.ProductSrvices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ECommercePlatformApplication.class)
class ProductRepoTest {

    @Autowired
    private ProductSrvices productSrvices;

    @Test
    void addProduct() {
        Product product = Product.builder()
                .productName("Laptop hp")
                .description("Laptop hp 550 g8 i5 11eme gen 8 ram")
                .price(80000)
                .createdAt(LocalDateTime.now())
                .category(Category.LAPTOPS)
                .productImage(null)
                .build();
        productSrvices.addProduct(product);
    }

    @Test
    public void deleteProduct() {
        productSrvices.deleteProduct(3L);
    }

    @Test
    void updateProduct() {
        Product product = Product.builder()
                .price(85000)
                .build();
        productSrvices.updateProduct(4L, product);
    }
    @Test
    void getAllProducts() {
        List<Product> products = productSrvices.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getProductId() + " | " + product.getProductName() + " | " + product.getDescription() + " | " + product.getPrice() + " | " + product.getCreatedAt() + " | " + product.getCategory());
        }
    }
}