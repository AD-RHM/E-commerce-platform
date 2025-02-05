package Repositories;

import Entities.Cart;
import Entities.CartProduct;
import Entities.Product;
import Entities.StockProduct;
import Services.ProductSrvices;
import Services.StockProductServices;
import Services.UserServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ECommercePlatformApplication.class)
class CartProductRepoTest {

    @Autowired
    CartProductRepo cartProductRepo;
    @Autowired
    UserServices userServices;
    @Autowired
    ProductSrvices productSrvices;
    @Autowired
    StockProductServices stockProductServices;

    @Test
    public void addProductToCart() {
        Product product = productSrvices.getProductById(1L);
        Cart cart = userServices.getUserByIdUser(5L).getCart();
        StockProductServices stockProduct = stockProductServices.
        CartProduct cartProduct = CartProduct.builder()
                .cartInCart_Product(cart)
                .productInCart_Product(product)
                .quantity(50)
                .build();

        cartProductRepo.save(cartProduct);
    }


}