package Repository;

import Model.Role;
import Model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;


public class UserRepository implements InitialFunctions<User>{

    private final CartRepository cartRepository;
    public UserRepository() {
        this.cartRepository = new CartRepository();
    }

    // Extracted constant for SQL query
    private static final String INSERT_USER_SQL = "INSERT INTO users (userId,FirstName, LastName, Email, Password, role, PhoneNumber, Address, City, image, cart) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String sqlDeleteUser = "DELETE FROM users WHERE Id = ?"; // Constant SQL query
    private static final String UPDATE_USER_SQL = "UPDATE users SET FirstName = ?, LastName = ?, Email = ?, Password = ?, PhoneNumber = ?, Address = ?, City = ?, image = ? WHERE userId = ?";
    private static final String SELECT_USER_SQL = "SELECT * FROM users WHERE userId = ?";
    private static final String SELECT_ALL_USER_SQL = "SELECT * FROM users";
    private static final String CHECK_UNIQUE_USER_SQL = "SELECT userId FROM users WHERE email = ?";
    private static final String CHECK_USER_SQL = "SELECT userId FROM users WHERE email = ? AND password = ?";

    @Override
    public boolean add(User user) {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, String.valueOf(user.getRole()));
            preparedStatement.setString(7, user.getPhoneNumber());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getCity());
            preparedStatement.setString(10, user.getImage());
            preparedStatement.setString(11, user.getCart().getCartId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding user", e);
        }
    }

    @Override
    public boolean delete(String id) {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(sqlDeleteUser)) {
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate() > 0; // Execute the deletion
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user with id: " + id, e); // Improved error message
        }
    }

    @Override
    public boolean edit(User user) {
        final int IDX_FIRST_NAME = 1;
        final int IDX_LAST_NAME = 2;
        final int IDX_EMAIL = 3;
        final int IDX_PASSWORD = 4;
        final int IDX_PHONE_NUMBER = 5;
        final int IDX_ADDRESS = 6;
        final int IDX_CITY = 7;
        final int IDX_IMAGE = 8;
        final int IDX_USER_ID = 9;
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(UPDATE_USER_SQL)) {
            preparedStatement.setString(IDX_FIRST_NAME, user.getFirstName());
            preparedStatement.setString(IDX_LAST_NAME, user.getLastName());
            preparedStatement.setString(IDX_EMAIL, user.getEmail());
            preparedStatement.setString(IDX_PASSWORD, user.getPassword());
            preparedStatement.setString(IDX_PHONE_NUMBER, user.getPhoneNumber());
            preparedStatement.setString(IDX_ADDRESS, user.getAddress());
            preparedStatement.setString(IDX_CITY, user.getCity());
            preparedStatement.setString(IDX_IMAGE, user.getImage());
            preparedStatement.setString(IDX_USER_ID, user.getUserId());
            return preparedStatement.executeUpdate() > 0; // Return true if at least one row is updated
        } catch (SQLException e) {
            throw new RuntimeException("Error updating user with ID: " + user.getUserId(), e);
        }
    }

    @Override
    public Optional<User> findById(String id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            CartRepository cart = new CartRepository();
            if (resultSet.next()) {
                User user = mapToUser(resultSet);
                cartRepository.findByUserId(user.getUserId()).ifPresent(user::setCart);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user with ID: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = mapToUser(resultSet);
                cartRepository.findByUserId(user.getUserId()).ifPresent(user::setCart);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de tous les utilisateurs", e);
        }
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("userId"));
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
        return user;
    }

    public boolean checkUniqueUser(String email) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_UNIQUE_USER_SQL)) {

            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la vérification de l'unicité de l'utilisateur", e);
        }
    }

    public boolean checkUser(String email, String password) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_SQL)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la vérification de l'existance de l'utilisateur", e);
        }
    }

}