package Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CartID")
    private Long cartId;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @Column(name = "UserID", nullable = false)
    private Long userID;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))

    private List<Product> products;


    public Cart() {
        // Constructor can remain empty if no additional logic is needed
        products = new ArrayList<>();
    }


}