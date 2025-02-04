package Services;

import Repositories.StockProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockProductServices {
    @Autowired
    StockProductRepo stockProductRepo;
    @Autowired
    public StockProductServices(StockProductRepo stockProductRepo) {
        this.stockProductRepo = stockProductRepo;
    }


}
