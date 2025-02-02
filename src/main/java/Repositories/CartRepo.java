package Repositories;

import Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface CartRepo extends JpaRepository<Cart, Long> {
    @Query(
            value = "Select * from users left join cart on users.userid = cart.userid where userid = :userid",
            nativeQuery = true
    )
    Cart findByUser_UserId(@Param("userid") Long userId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE cart set label = label, update_at = update_at where cartid = cartid",
            nativeQuery = true
    )
    void editCart(@Param("label") String label, @Param("update_at")LocalDateTime update_at, @Param("cartid") Long cartid);
}
