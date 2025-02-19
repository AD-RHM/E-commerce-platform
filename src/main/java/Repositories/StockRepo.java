package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


public interface StockRepo extends JpaRepository<Stock, Long> {
    @Query(
            value = "Select * from stock where stock_name = :stock_name",
            nativeQuery = true
    )
    Stock findByName(@Param("stock_name") String name);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE stock SET stock_name = :stock_name, updated_at = :updated_at where stockid = :stockid",
            nativeQuery = true
    )
    void updateStockName(@Param("stockid") Long id, @Param("stock_name") String name, @Param("updated_at") LocalDateTime updatedAt);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE stock SET location = :location, updated_at = :updated_at where stockid = :stockid",
            nativeQuery = true
    )
    void updateStockLocation(@Param("stockid") Long id, @Param("location") String location, @Param("updated_at") LocalDateTime updatedAt);
}
