package Repositories;

import Entities.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockProductRepo extends JpaRepository<StockProduct, Long> {
}
