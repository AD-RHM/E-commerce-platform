package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name = "orederid")
    private Long orderId;

    @Column(name = "quantity", nullable = false, columnDefinition = "Integer")
    private Integer quantity_ordred;

    @Column(name = "ordred_at", nullable = false)
    private LocalDate ordred_at;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;


    @Column(name = "transport_type")
    private String transport_type;

    @Column(name = "transport_price")
    private double transport_price;

    @Column(name = "address")
    private String address;

    //    @Enumerated(EnumType.ORDINAL)
    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "town", nullable = false)
    private String town;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userOrder;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_id"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product productOrder;
}

