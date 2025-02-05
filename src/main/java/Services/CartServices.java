package Services;

import Entities.Cart;
import Repositories.CartRepo;
import Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServices {

    private final CartRepo cartRepo;
    private final UserRepo userRepo;

    @Autowired
    public CartServices(CartRepo cartRepo, UserRepo userRepo) {
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
    }
    public Cart getCart(Long id) {
        return userRepo.findById(id).get().getCart();
    }

    public Cart getCartByUser(Long userId) {
        return userRepo.findById(userId).get().getCart();
    }

    public List<Cart> getAllCart() {
        return cartRepo.findAll();
    }

    public void editCartName(Long idUser, String label) {
        Cart cart = userRepo.findById(idUser).get().getCart();
        cartRepo.editCart(label, LocalDateTime.now(), cart.getCartId());
    }
    public void deleteCart(Long userid) {
        cartRepo.deleteByUserId(userid);
    }
}
