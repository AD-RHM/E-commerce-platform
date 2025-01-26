package Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "cart_id", columnDefinition = "BIGINT",referencedColumnName = "cartID",nullable = false)
    private Cart cartInCart_Product;

    @ManyToOne
    @JoinColumn(name = "product_id", columnDefinition = "BIGINT",referencedColumnName = "productID", nullable = false)
    private Product productInCart_Product;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}

