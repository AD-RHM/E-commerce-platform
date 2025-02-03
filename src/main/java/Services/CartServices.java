package Services;

import Entities.Cart;
import Repositories.CartRepo;
import Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CartServices {

    private final CartRepo cartRepo;
    private final UserRepo userRepo;

    @Autowired
    public CartServices(CartRepo cartRepo, UserRepo userRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
    }
//    public Cart getCart() {
//        return userRepo.findById(4L).get().getCart();
//    }

    public void editCartName(Long idUser, String label) {
        Cart cart = userRepo.findById(4L).get().getCart();
        cartRepo.editCart(label, LocalDateTime.now(), cart.getCartId());
    }
}
