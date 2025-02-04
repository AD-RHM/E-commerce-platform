package Services;

import Entities.Stock;
import Repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockServices {

    @Autowired
    private StockRepo stockRepo;

    @Autowired
    public StockServices(StockRepo stockRepo) {
        this.stockRepo = stockRepo;
    }

    public void add(Stock stock) {
        stockRepo.save(stock);
    }
    public Stock findById(Long id) {
        return stockRepo.findById(id).get();
    }
    public List<Stock> findAll() {
        return stockRepo.findAll();
    }
    public void delete(Long id) {
        stockRepo.deleteById(id);
    }
    public Stock findByName(String name) {
        return stockRepo.findByName(name);
    }
    public Stock updateStock(Long id, Stock stock) {
        if (stockRepo.existsById(id)) {
            if (stock != null) {
                if (stock.getStockName() != null) {stockRepo.updateStockName(id,stock.getStockName(), LocalDateTime.now());}
                if (stock.getLocation() != null) {stockRepo.updateStockLocation(id,stock.getLocation(), LocalDateTime.now());}
            }
            return stockRepo.findById(id).orElse(null);
        }
        return stockRepo.findById(id).orElse(null);
    }
}
