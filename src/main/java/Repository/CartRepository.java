package Repository;

import Model.Cart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartRepository implements InitialFunctions<Cart>{

    private static final String INSERT_CART_SQL = "INSERT INTO carts (customerId, cartName) VALUES (?, ?)";
    private static final String DELETE_CART_SQL = "DELETE FROM carts WHERE cartId = ?";
    private static final String UPDATE_CART_SQL = "UPDATE carts SET customerId = ?, cartName = ? WHERE cartId = ?";
    private static final String SELECT_CART_SQL = "SELECT * FROM carts WHERE cartId = ?";
    private static final String SELECT_ALL_CART_SQL = "SELECT * FROM carts";
    private static final String SELECT_USER_CART_SQL = "SELECT * FROM carts WHERE customer_id = ?";

    @Override
    public boolean add(Cart cart) {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setLong(1, cart.getCustomerId());
            preparedStatement.setString(2, cart.getCartName());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding cart", e);
        }
    }


    @Override
    public boolean delete(Long id) {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(DELETE_CART_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression du panier avec l'ID: " + id, e);
        }
    }


    @Override
    public boolean edit(Cart cart) throws SQLException {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(UPDATE_CART_SQL)) {
            preparedStatement.setLong(1, cart.getCustomerId());
            preparedStatement.setString(2, cart.getCartName());
            preparedStatement.setLong(3, cart.getCartId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la mise à jour du panier avec l'ID: " + cart.getCartId(), e);
        }
    }



    @Override
    public Optional<Cart> findById(Long id) throws SQLException {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(SELECT_CART_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cart cart = new Cart();
                cart.setCartId(resultSet.getLong("cartId"));
                cart.setCustomerId(resultSet.getLong("customerId"));
                cart.setCartName(resultSet.getString("cartName"));
                // Assume that the cart's products will be populated somewhere else.
                return Optional.of(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la recherche du panier avec l'ID: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Cart> findAll() throws SQLException {
        try( var connectionDB = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connectionDB.prepareStatement(SELECT_ALL_CART_SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cart> carts = new ArrayList<>();
            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setCartId(resultSet.getLong("cartId"));
                cart.setCustomerId(resultSet.getLong("customerId"));
                cart.setCartName(resultSet.getString("cartName"));
                carts.add(cart);
            }
            return carts;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all carts", e);
        }
        }

    public Optional<Cart> findByUserId(Long user_id) throws SQLException {
        try (var connectionDB = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connectionDB.prepareStatement(SELECT_USER_CART_SQL)) {
            preparedStatement.setLong(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Cart cart = new Cart();
                cart.setCartId(resultSet.getLong("cart_id"));
                cart.setCustomerId(resultSet.getLong("customer_id"));
                cart.setCartName(resultSet.getString("cart_name"));
                // Assume that the cart's products will be populated somewhere else.
                return Optional.of(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la recherche du panier avec l'ID: " + user_id, e);
        }
        return Optional.empty();
    }
}
