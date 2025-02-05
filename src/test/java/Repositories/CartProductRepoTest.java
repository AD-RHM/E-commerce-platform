package Repositories;

import Entities.Cart;
import Entities.CartProduct;
import Entities.Product;
import Services.CartProductServices;
import Services.ProductSrvices;
import Services.StockProductServices;
import Services.UserServices;
import com.RAHMANE.E_commerce.platforme.ECommercePlatformApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ECommercePlatformApplication.class)
class CartProductRepoTest {

    @Autowired
    CartProductServices cartProductServices;
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
        Long stockProduct = stockProductServices.getQuantity(1L,1L);
        CartProduct cartProduct = CartProduct.builder()
                .cartInCart_Product(cart)
                .productInCart_Product(product)
                .quantity(50)
                .build();
        if (cartProduct.getQuantity() <= stockProduct) {cartProductServices.addProductToCart(cartProduct);}
    }

    @Test
    public void removeProductFromCart() {
        cartProductServices.removeProductFromCart(1L,1L);
    }

    @Test
    public void updateProductInCart() {
        cartProductServices.updateProductQuantity(1L, 5L, 60);
    }

    @Test
    public void getProductInCart() {
        List<CartProduct> cartProducts = cartProductServices.getProductsFromCart(5L);
        for (CartProduct cartProduct : cartProducts) {
            System.out.println(cartProduct.getProductInCart_Product().getProductName() + " : " + cartProduct.getQuantity() + " Pieces");
        }
    }


}