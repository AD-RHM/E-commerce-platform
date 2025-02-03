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
//    @Query(
//            value = "Select cart.cartid, cart.created_at, cart.label, cart.updated_at, cart.userid " +
//                    "from users left join cart on users.userid = cart.userid where users.userid = :userid",
//            nativeQuery = true
//    )
//    Cart findByUserId(@Param("userid") Long userId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE cart set label = :label, updated_at = :updated_at where cartid = :cartid",
            nativeQuery = true
    )
    void editCart(@Param("label") String label, @Param("updated_at")LocalDateTime updated_at, @Param("cartid") Long cartid);
}
