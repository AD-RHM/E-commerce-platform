package Repositories;

import Entities.Product;
import Entities.Stock;
import Entities.StockProduct;
import Services.ProductSrvices;
import Services.StockProductServices;
import Services.StockServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ECommercePlatformApplication.class)
class StockProductRepoTest {

    @Autowired
    private StockProductServices stockProductServices;
    @Autowired
    private ProductSrvices productSrvices;
    @Autowired
    private StockServices stockServices;

    @Test
    void addStockProduct() {
        Product product = productSrvices.getProductById(1L);
        Stock stock = stockServices.findById(1L);
        StockProduct stockProduct = StockProduct.builder()
                .quantity(100)
                .productInStock_Product(product)
                .stockInStock_Product(stock)
                .build();
        stockProductServices.addToStock(stockProduct);
    }

    @Test
    void updateStockProduct() {
        stockProductServices.updateQuantity(1L,50);
    }

    @Test
    void deleteStockProduct() {
        stockProductServices.deleteStockProduct(1L);
    }

}