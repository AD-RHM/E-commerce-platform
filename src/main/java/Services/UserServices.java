package Services;

import Model.Cart;
import Model.User;
import Repository.CartRepository;
import Repository.InitialFunctions;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private UserRepository userRepository;
    private CartRepository cartRepository;

    @Autowired
    public UserServices() {
        userRepository = new UserRepository();
        cartRepository = new CartRepository();
    }

    public boolean signUp(User user) {
        if (!userRepository.checkUniqueUser(user.getEmail())){
            Cart cart = new Cart();
            cart.setCartName(user.getFirstName() + " " + user.getLastName());
            cartRepository.add(cart);
            user.setCart(cart);
            userRepository.add(user);
            return true;
        }else return false;
    }

    public boolean login(User user) {
        return (userRepository.checkUser(user.getEmail(), user.getPassword()));
    }

    public boolean editProfile(User user) {
        if(user != null) {
            return userRepository.edit(user);
        }else return false;
    }

}
