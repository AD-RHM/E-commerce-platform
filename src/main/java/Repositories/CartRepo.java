package Repositories;

import Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "Delete from cart where cart.cartid = :cartid",
            nativeQuery = true
    )
    void deleteByUserId(@Param("cartid") Long id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE cart set label = :label, updated_at = :updated_at where cartid = :cartid",
            nativeQuery = true
    )
    void editCart(@Param("label") String label, @Param("updated_at")LocalDateTime updated_at, @Param("cartid") Long cartid);

}
