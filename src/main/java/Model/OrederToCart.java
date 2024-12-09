package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrederToCart {

    private String quantity;
    private String productId;
    private String cartId;

    public OrederToCart(String quantity, String productId, String cartId) {
        this.quantity = quantity;
        this.productId = productId;
        this.cartId = cartId;
    }

    public OrederToCart() {}
}
