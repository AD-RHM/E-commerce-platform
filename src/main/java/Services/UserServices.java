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


    public boolean signUp(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            Cart cart = new Cart();
            cart.setLabel(user.getFirstName() +" "+ user.getLastName());
            cart.setCreatedAt(LocalDateTime.now());
            cart.setUpdatedAt(LocalDateTime.now());
            cart.setUser(user);
            userRepository.save(user);
            cartRepository.save(cart);
            return true;
        }else return false;
    }

    public User login(String email, String password) {
        if (userRepository.existsByEmail(email)) {
            return userRepository.findByEmailAndPassword(email, password);
        }
        else return null;
    }

//    public boolean editProfile(User user) {
//        if(user != null) {
//            return true;
//        }else return false;
//    }

}
