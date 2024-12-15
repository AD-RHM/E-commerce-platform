package Model;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "price")
    private double price;

    @Column(name = "initial_Quantity")
    private int initial_quantity;

    @Column(name = "quantity_left")
    private int quantity_left;

    @Column(name = "releasedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime releasedDate;


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInitial_quantity() {
        return initial_quantity;
    }

    public void setInitial_quantity(int initial_quantity) {
        this.initial_quantity = initial_quantity;
    }

    public int getQuantity_left() {
        return quantity_left;
    }

    public void setQuantity_left(int quantity_left) {
        this.quantity_left = quantity_left;
    }

    public LocalDateTime getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDateTime releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Product() {
    }
}
