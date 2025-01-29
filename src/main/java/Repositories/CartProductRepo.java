package Repositories;

import Entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepo extends JpaRepository<CartProduct, Long> {
}
