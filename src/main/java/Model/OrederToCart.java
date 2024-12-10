package Model;

import lombok.Getter;
import lombok.Setter;


public class OrederToCart {

    private String quantity;
    private String productId;
    private String cartId;

    public OrederToCart(String quantity, String productId, String cartId) {
        this.quantity = quantity;
        this.productId = productId;
        this.cartId = cartId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public OrederToCart() {}
}
