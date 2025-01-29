package Repositories;

import Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findUserByPasswordAndEmail(String password, String email);
}