package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    @NonNull
    private String label;

    @NonNull
    private String description;

    @NonNull
    private String image;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Category category;

    private double price;

    private int initial_quantity;

    private int quantity_left;

    @NonNull
    private LocalDateTime releasedDate;

    private Long userId;


    public Product() {
        this.quantity_left = this.initial_quantity;
    }

}
