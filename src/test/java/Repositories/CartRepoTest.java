package Repositories;

import Entities.Cart;
import Services.CartServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ECommercePlatformApplication.class)
class CartRepoTest {

    @Autowired
    CartServices cartServices;

    @Test
    public void editCart() {
        cartServices.editCartName(1L, "CHANGED LABEL");
    }

    @Test
    public void showAllCart() {
        List<Cart> cartList = cartServices.getAllCart();
        for (Cart cart : cartList) {
            System.out.println(cart.getCartId() + " " + cart.getLabel());
        }
    }

}