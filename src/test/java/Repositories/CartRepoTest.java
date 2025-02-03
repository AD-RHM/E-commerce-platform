package Repositories;

import Services.CartServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ECommercePlatformApplication.class)
class CartRepoTest {

    @Autowired
    CartServices cartServices;

    @Test
    public void showCart() {
//        cartServices.editCartName(2L,"new label");
        cartServices.editCartName(4L, "test");
    }

}