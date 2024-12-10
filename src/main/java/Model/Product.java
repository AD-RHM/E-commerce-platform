package Model;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Product {

    @Id
    private String product_id = UUID.randomUUID().toString();

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

    private LocalDateTime releasedDate;

    private Long userId;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public @NonNull String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    public @NonNull String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public @NonNull String getImage() {
        return image;
    }

    public void setImage(@NonNull String image) {
        this.image = image;
    }

    public @NonNull Category getCategory() {
        return category;
    }

    public void setCategory(@NonNull Category category) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Product() {
        this.quantity_left = this.initial_quantity;
    }

}
