package Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
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
    @Column(name = "cartid", nullable = false, updatable = false)
    private Long cartId;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToMany(mappedBy = "cartInCart_Product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<CartProduct> cartProducts = new ArrayList<>();

}