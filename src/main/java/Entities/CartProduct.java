package Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cart_product")
public class CartProduct {

    @Id
    @SequenceGenerator(
            name = "cart_product_sequence",
            sequenceName = "cart_product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_product_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "cartID",
            nullable = false
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cart cartInCart_Product;

    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "productID",
            nullable = false
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product productInCart_Product;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}

