package Repositories;

import Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Long> {
    Stock findByStockID(long stockID);
}
