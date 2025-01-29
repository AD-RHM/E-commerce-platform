package Entities;

import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", columnDefinition = "BIGINT",referencedColumnName = "productID",nullable = false)
    private Product productInStock_Product;

    @ManyToOne
    @JoinColumn(name = "stock_id", columnDefinition = "BIGINT",referencedColumnName = "stockID", nullable = false)
    private Stock stockInStock_Product;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}
