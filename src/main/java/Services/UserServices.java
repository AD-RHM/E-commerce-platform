package Services;

import Entities.Cart;
import Entities.User;
import Repositories.CartRepo;
import Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//public class UserServices {
//
//    private UserRepo userRepository;
//    private CartRepo cartRepository;
//
//    @Autowired
//    public UserServices() {
//
//    }
//
//    public boolean signUp(User user) {
//        if (!userRepository.existsByEmail(user.getEmail())){
//            Cart cart = new Cart();
//            cart.setLabel(user.getFirstName() + user.getLastName() + "cart");
//            user.setCart(cart);
//            cartRepository.save(cart);
//
//            userRepository.save(user);
//            return true;
//        }else return false;
//    }

//    public boolean login(User user) {
//        return (userRepository.checkUser(user.getEmail(), user.getPassword()));
//    }
//
//    public boolean editProfile(User user) {
//        if(user != null) {
//            return userRepository.edit(user);
//        }else return false;
//    }

//}
