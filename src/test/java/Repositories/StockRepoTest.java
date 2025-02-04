package Repositories;

import Entities.Stock;
import Services.StockServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;


@SpringBootTest(classes = ECommercePlatformApplication.class)
class StockRepoTest {
    @Autowired
    private StockServices stockServices;

    @Test
    void addStock() {
        Stock stock = Stock.builder()
                .stockName("Stock 02")
                .location("Setif")
                .createdAt(LocalDateTime.now())
                .build();
        stockServices.add(stock);
    }

    @Test
    void updateStock() {
        Stock stock = Stock.builder()
                .updatedAt(LocalDateTime.now())
                .location("El eulma hourai boumedien")
                .build();
        stockServices.updateStock(1L,stock);
    }

    @Test
    void deleteStock() {
        stockServices.delete(2L);
    }

    @Test
    void getStock() {
        System.out.println(stockServices.findByName("Stock 01").getLocation());
    }

}