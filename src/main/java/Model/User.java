package Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @NonNull @Getter @Setter
    private String FirstName;
    @NonNull @Getter @Setter
    private String LastName;
    @NonNull @Getter @Setter
    private String Email;
    @NonNull @Getter @Setter
    private String Password;
    @Enumerated(EnumType.STRING)
    private Role Role;

    public User() {};
    public User(String FirstName, String LastName, String Email, String Password, Role Role) {}
}
