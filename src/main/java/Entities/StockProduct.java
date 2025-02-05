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
@Table(name = "stock_product")
public class StockProduct {

    @Id
    @SequenceGenerator(
            name = "stock_product_sequence",
            sequenceName = "stock_product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_product_sequence"
    )
    @Column(name = "stock_product_id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product productInStock_Product;

    @ManyToOne
    @JoinColumn(name = "stock_id", foreignKey = @ForeignKey(name = "fk_stock"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Stock stockInStock_Product;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
