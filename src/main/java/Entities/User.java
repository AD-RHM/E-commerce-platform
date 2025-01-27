package Entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

    @Id
    @SequenceGenerator(
            name = "Users_Sequence",
            sequenceName = "Users_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Users_Sequence"
    )
    @Column(name = "userid", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "first_name" , nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "password_hash", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user")
    private Cart cart;


}