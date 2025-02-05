package Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity(name = "Product")
@Builder
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(name = "productID")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Category" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "productInCart_Product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<CartProduct> cartProducts = new ArrayList<>();

    @OneToMany(mappedBy = "productInStock_Product")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<StockProduct> stockProducts = new ArrayList<>();

}
