package Repository;

import Model.Cart;
import Model.Role;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public class UserRepository implements InitialFunctions<User> {

    // Extracted constant for SQL query
    private static final String INSERT_USER_SQL =
            "INSERT INTO users (FirstName, LastName, Email, Password, role, PhoneNumber, Address, City, image, cart) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public boolean add(User user) {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, String.valueOf(user.getRole()));
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getCity());
            preparedStatement.setString(9, user.getImage());
            preparedStatement.setLong(10, user.getCart().getCartId());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error adding user", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String sqlDeleteUser = "DELETE FROM users WHERE Id = ?"; // Constant SQL query

        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(sqlDeleteUser)) {

            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0; // Execute the deletion

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user with id: " + id, e); // Improved error message
        }
    }

    @Override
    public boolean edit(User user) {
        final String UPDATE_USER_SQL =
                "UPDATE users SET FirstName = ?, LastName = ?, Email = ?, Password = ?, role = ?, " +
                        "PhoneNumber = ?, Address = ?, City = ?, image = ?, cart = ? WHERE userId = ?";

        final int IDX_FIRST_NAME = 1;
        final int IDX_LAST_NAME = 2;
        final int IDX_EMAIL = 3;
        final int IDX_PASSWORD = 4;
        final int IDX_ROLE = 5;
        final int IDX_PHONE_NUMBER = 6;
        final int IDX_ADDRESS = 7;
        final int IDX_CITY = 8;
        final int IDX_IMAGE = 9;
        final int IDX_CART = 10;
        final int IDX_USER_ID = 11;

        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(UPDATE_USER_SQL)) {

            preparedStatement.setString(IDX_FIRST_NAME, user.getFirstName());
            preparedStatement.setString(IDX_LAST_NAME, user.getLastName());
            preparedStatement.setString(IDX_EMAIL, user.getEmail());
            preparedStatement.setString(IDX_PASSWORD, user.getPassword());
            preparedStatement.setString(IDX_ROLE, user.getRole().name());
            preparedStatement.setString(IDX_PHONE_NUMBER, user.getPhoneNumber());
            preparedStatement.setString(IDX_ADDRESS, user.getAddress());
            preparedStatement.setString(IDX_CITY, user.getCity());
            preparedStatement.setString(IDX_IMAGE, user.getImage());
            preparedStatement.setLong(IDX_CART, user.getCart().getCartId());
            preparedStatement.setLong(IDX_USER_ID, user.getUserId());

            return preparedStatement.executeUpdate() > 0; // Return true if at least one row is updated

        } catch (SQLException e) {
            throw new RuntimeException("Error updating user with ID: " + user.getUserId(), e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        String query = "SELECT * FROM users WHERE userId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                Cart cart = new Cart();
                user.setUserId(resultSet.getLong("userId"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                user.setPhoneNumber(resultSet.getString("PhoneNumber"));
                user.setAddress(resultSet.getString("Address"));
                user.setCity(resultSet.getString("City"));
                user.setImage(resultSet.getString("image"));
                user.setCreatedAt(resultSet.getObject("createdat", LocalDateTime.class));
                // A ajouter selon le modèle
                user.setCart(new Cart());
                return Optional.of(user);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Idéalement, connectez-vous en utilisant un Logger
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return List.of(); // Method not yet implemented
    }
}