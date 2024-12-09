package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    private Long customerId;

    private String cartName;

    @ManyToMany
    @NonNull
    private List<Product> products = new ArrayList<>();

    public Cart() {
        // Constructor can remain empty if no additional logic is needed
    }
}