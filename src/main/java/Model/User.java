package Model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;


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

    public User() {}

    public User(String firstName, String lastName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}