package Model;

import jakarta.persistence.*;


@Entity
@IdClass(CompositePK_OrderToCart.class)
@Table(name = "cart_products")
public class OrederToCart {

//    @EmbeddedId
//    CompositePK_OrderToCart compositePK_OrderToCart;
//    public CompositePK_OrderToCart getCompositePK_OrderToCart() {
//        return compositePK_OrderToCart;
//    }
//
//    public void setCompositePK_OrderToCart(Long cartId,Long productId) {
//        this.compositePK_OrderToCart.setCartId(cartId);
//        this.compositePK_OrderToCart.setProductId(productId);
//    }

    @Id
    @Column(name = "cart_id")
    private Long cartId;
    @Id
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private int quantity;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrederToCart() {}
}
