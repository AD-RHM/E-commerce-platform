package Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// Corrected interface name
public interface InitialFunctions<T> {
    boolean add(T t);

    boolean delete(Long id) throws SQLException;

    boolean edit(T t) throws SQLException;

    Optional<T> findById(Long id) throws SQLException; // Changed to return Optional<T>

    List<T> findAll() throws SQLException; // Returning a list of T
}