package Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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
    @JoinColumn(name = "product_id", columnDefinition = "BIGINT",referencedColumnName = "productID",nullable = false, foreignKey = @ForeignKey(name = "fk_product", foreignKeyDefinition = "ON DELETE CASCADE"))
    private Product productInStock_Product;

    @ManyToOne
    @JoinColumn(name = "stock_id", columnDefinition = "BIGINT",referencedColumnName = "stockID", nullable = false, foreignKey = @ForeignKey(name = "fk_stock", foreignKeyDefinition = "ON DELETE CASCADE"))
    private Stock stockInStock_Product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}
