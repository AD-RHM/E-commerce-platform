package Repositories;

import Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


public interface ProductRepo extends JpaRepository<Product, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "Update product set description = :description, update_at = :update_at where productid = :productid",
            nativeQuery = true
    )
    void updateProductDescription(@Param("description") String description, @Param("update_at") LocalDateTime update_at, @Param("productid") long id);

    @Modifying
    @Transactional
    @Query(
            value = "Update product set product_name = :product_name, update_at = :update_at where productid = :productid",
            nativeQuery = true
    )
    void updateProductName(@Param("product_name") String product_name, @Param("update_at") LocalDateTime update_at, @Param("productid") long id);

    @Modifying
    @Transactional
    @Query(
            value = "Update product set price = :price, update_at = :update_at where productid = :productid",
            nativeQuery = true
    )
    void updateProductPrice(@Param("price") double price, @Param("update_at") LocalDateTime update_at, @Param("productid") long id);



}
