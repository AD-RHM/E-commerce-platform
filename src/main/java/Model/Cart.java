package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    private String cartId = UUID.randomUUID().toString();

    private String customerId;

    private String cartName;

    @ManyToMany
    @NonNull
    private List<Product> products = new ArrayList<>();

    public Cart() {
        // Constructor can remain empty if no additional logic is needed
    }
}