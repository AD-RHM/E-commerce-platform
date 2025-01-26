package Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
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
    private Long product_id;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "Description", nullable = false)
    private String description;

    @Column(name = "Category" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "CreatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "productInCart_Product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProduct> cartProducts = new ArrayList<>();

    @OneToMany(mappedBy = "productInStock_Product", cascade = CascadeType.ALL)
    private List<StockProduct> stockProducts = new ArrayList<>();

}
