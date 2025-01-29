package Services;

import Entities.Cart;
import Entities.User;
import Repositories.CartRepo;
import Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServices {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private CartRepo cartRepository;

//    @Autowired
//    public UserServices() {
//
//    }

    public boolean signUp(User user) {
        if (!userRepository.existsByEmail(user.getEmail())){
            Cart cart = new Cart();
            cart.setLabel(user.getFirstName() + user.getLastName() + "cart");
            cart.setCreatedAt(LocalDateTime.now());
            user.setCart(cart);
            cartRepository.save(cart);
            userRepository.save(user);
            return true;
        }else return false;
    }

    public User login(String email, String password) {
        return (userRepository.findUserByPasswordAndEmail(password, email));
    }

//    public boolean editProfile(User user) {
//        if(user != null) {
//            return true;
//        }else return false;
//    }

}
