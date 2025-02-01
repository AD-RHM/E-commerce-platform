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

    @Autowired
    public UserServices(UserRepo userRepository, CartRepo cartRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }


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
        if (userRepository.existsByEmail(email)) {return userRepository.findByEmailAndPassword(email, password);}
        else return null;
    }



    public User editProfile(User user) {
        if(user != null) {
            if (user.getFirstName() != null) {userRepository.updateFirstName(user.getUserId(), user.getFirstName());}
            if (user.getLastName() != null) {userRepository.updateLastName(user.getUserId(), user.getLastName());}
            if (user.getEmail() != null) {userRepository.updateEmail(user.getUserId(), user.getEmail());}
            if (user.getPassword() != null) {userRepository.updatePassword(user.getUserId(), user.getPassword());}
            return userRepository.findById(user.getUserId()).orElse(null);
        }else return null;
    }

}
