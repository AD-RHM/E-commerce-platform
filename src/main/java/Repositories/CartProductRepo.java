package Repositories;

import Entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartProductRepo extends JpaRepository<CartProduct, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "delete from cart_product where product_id = :product_id and cart_id = :cart_id",
            nativeQuery = true
    )
    void deleteByCartIdAndProductId(Long cartId, Long productId);

    @Query(
            value = "Select * from cart_product where cart_id = :cart_id",
            nativeQuery = true
    )
    List<CartProduct> getProductsFromCart(@Param("cart_id") Long cartId);
}
