package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrederToCart {

    private int quantity;
    private Long productId;
    private Long cartId;

    public OrederToCart(int quantity, Long productId, Long cartId) {
        this.quantity = quantity;
        this.productId = productId;
        this.cartId = cartId;
    }

    public OrederToCart() {}
}
