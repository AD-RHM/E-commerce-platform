package Model;

import jakarta.persistence.*;
import lombok.NonNull;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long cartId;


    @Column(name = "cart_name")
    private String cartName;

    @ManyToMany
    private List<Product> products;


    public Cart() {
        // Constructor can remain empty if no additional logic is needed
        products = new ArrayList<>();
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}