package Services;

import Entities.CartProduct;
import Repositories.CartProductRepo;
import Repositories.CartRepo;
import Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductServices {
    @Autowired
    private CartProductRepo cartProductRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    public CartProductServices(CartProductRepo cartProductRepo,CartRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        this.cartProductRepo = cartProductRepo;
    }

    public void addProductToCart(CartProduct cartProduct) {
        cartProductRepo.save(cartProduct);
    }
    public void removeProductFromCart(Long productId, Long cartId) {
        cartProductRepo.deleteByCartIdAndProductId(cartId, productId);
    }
    public void updateProductQuantity(Long productId ,Long cartId , Integer quantity) {
        cartProductRepo.updateQuantity(productId, cartId, quantity);
    }
    public List<CartProduct> getProductsFromCart(Long cartId) {
        return cartProductRepo.getProductsFromCart(cartId);
    }


}
