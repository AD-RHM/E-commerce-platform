package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// Corrected interface name
@Repository
public interface InitialFunctions<T>{
    boolean add(T t);

    boolean delete(Long id);

    boolean edit(T t);

    Optional<T> findById(Long id); // Changed to return Optional<T>

    List<T> findAll(); // Returning a list of T
}