package Services;

import Entities.Cart;
import Repositories.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartServices {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    public CartServices(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    public void editCartName(Long idUser, String label) {
        Cart cart = cartRepo.findByUser_UserId(idUser);
        cartRepo.editCart(label, LocalDateTime.now(), cart.getCartId());
    }
}
