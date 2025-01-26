package Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "Price")
    private double price;

    @Column(name = "CreatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "UpdateAt")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateAt;

    @ManyToMany(mappedBy = "productsInCart")
    @JoinColumn
    private List<Cart> carts;

    @ManyToMany(mappedBy = "productsInStock")
    @JoinColumn
    private List<Stock> stocks;

}
