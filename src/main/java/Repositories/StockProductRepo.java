package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StockProductRepo extends JpaRepository<StockProduct, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE stock_product SET quantity = :quantity where product_id = :product_id",
            nativeQuery = true
    )
    void updateQuantity(@Param("product_id") Long product_id, @Param("quantity") Integer quantity);

    @Modifying
    @Transactional
    @Query(
            value = "delete from stock_product where product_id = :product_id and stock_id = :stock_id",
            nativeQuery = true
    )
    void deleteProduct(@Param("product_id") Long product_id, @Param("stock_id") Long stock_id);

    @Query(
            value = "SELECT quantity from stock_product where product_id = :product_id and stock_id = :stock_id",
            nativeQuery = true
    )
    Long getQuantity(@Param("stock_id") Long stock_id, @Param("product_id") Long product_id);
}
