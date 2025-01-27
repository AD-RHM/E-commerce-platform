package Entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cart")
@Table(name = "cart")
@Builder
public class Cart {

    @Id
    @SequenceGenerator(
            name = "Cart_Sequence",
            sequenceName = "Cart_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Cart_Sequence"
    )
    @Column(name = "CartID", nullable = false, updatable = false)
    private Long cartId;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "UserID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cartInCart_Product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProduct> cartProducts = new ArrayList<>();

}