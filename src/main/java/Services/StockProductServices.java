package Services;

import Entities.StockProduct;
import Repositories.ProductRepo;
import Repositories.StockProductRepo;
import Repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockProductServices {

    @Autowired
    StockProductRepo stockProductRepo;
    @Autowired
    StockRepo stockRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    public StockProductServices(StockProductRepo stockProductRepo, StockRepo stockRepo, ProductRepo productRepo) {
        this.stockProductRepo = stockProductRepo;
        this.stockRepo = stockRepo;
        this.productRepo = productRepo;
    }

    public void addToStock(StockProduct stockProduct) {
        stockProductRepo.save(stockProduct);
    }
    public void updateQuantity(Long productId, Integer quantity) {
        stockProductRepo.updateQuantity(productId, quantity);
    }
    public void deleteStockProduct(Long productId, Long stockId) {
        stockProductRepo.deleteProduct(productId, stockId);
    }
    public Long getQuantity(Long productId, Long stockId) {

    }


}
