package Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
@Entity(name = "Stock")
@Builder
public class Stock {

    @Id
    @SequenceGenerator(
            name = "stock_sequence",
            sequenceName = "stock_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )
    @Column(
            name = "stockID",
            updatable = false,
            nullable = false
    )
    private Long stockID;
    @Column(name = "stockName")
    private String stockName;
    @Column(name = "location")
    private String location;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "stockInStock_Product", cascade = CascadeType.ALL)
    private List<StockProduct> stockProducts = new ArrayList<>();

}
