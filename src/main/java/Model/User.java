package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class User {

    @Id
    private String userId = UUID.randomUUID().toString();

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String address;

    @NonNull
    private String city;

    @NonNull
    private String image;

    @NonNull
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    // Lets the cart be optionally injected
    public User() {
    }
}