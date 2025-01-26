package Model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "User")
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "Email_Unique_Constraint", columnNames = "Email")
        })
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
    @Column(name = "UserID", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "FirstName" , nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name = "LastName", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "Email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "PasswordHash", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    @Column(name = "CreatedAt", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "cartID")
    private Cart cart;

    public User(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}