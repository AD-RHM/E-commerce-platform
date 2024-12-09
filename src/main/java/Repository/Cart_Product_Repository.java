package Repository;

import Model.OrederToCart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart_Product_Repository implements InitialFunctions<OrederToCart>{
    private static final String INSERT_CART_PRODUCT_SQL = "INSERT INTO cart_products (cart_id, product_id,quantity) VALUES (?, ?, ?)";
    private static final String DELETE_CART_PRODUCT_SQL = "DELETE FROM cart_products WHERE cart_id = ? and product_id = ?";
    private static final String UPDATE_CART_PRODUCT_SQL = "UPDATE cart_products SET quantity = ? WHERE cart_id = ? and product_id = ?";
    private static final String SELECT_CART_PRODUCT_SQL = "SELECT * FROM cart_products WHERE cart_id = ? and product_id = ?";
    private static final String SELECT_ALL_CART_PRODUCT_SQL = "SELECT * FROM cart_products";


    @Override
    public boolean add(OrederToCart orederToCart) {
        try(var connectionDB = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connectionDB.prepareStatement(INSERT_CART_PRODUCT_SQL)) {
            preparedStatement.setLong(1, orederToCart.getCartId());
            preparedStatement.setLong(2, orederToCart.getProductId());
            preparedStatement.setInt(3, orederToCart.getQuantity());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding Order to cart", e);
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        try(var connectionDB = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connectionDB.prepareStatement(DELETE_CART_PRODUCT_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error delete Order from cart", e);
        }

    }

    @Override
    public boolean edit(OrederToCart orederToCart) throws SQLException {
        try(var connectionDB = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connectionDB.prepareStatement(UPDATE_CART_PRODUCT_SQL)) {
            preparedStatement.setInt(1, orederToCart.getQuantity());
            preparedStatement.setLong(2, orederToCart.getCartId());
            preparedStatement.setLong(3, orederToCart.getProductId());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new RuntimeException("Error update Order to cart", e);
        }
    }

    @Override
    public Optional<OrederToCart> findById(Long id) throws SQLException {
        try(var connectionDB = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connectionDB.prepareStatement(SELECT_CART_PRODUCT_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                OrederToCart orederToCart = new OrederToCart();
                orederToCart.setCartId(resultSet.getLong("cart_id"));
                orederToCart.setProductId(resultSet.getLong("product_id"));
                orederToCart.setQuantity(resultSet.getInt("quantity"));
                return Optional.of(orederToCart);
            }
        }catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la recherche du panier avec l'ID: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<OrederToCart> findAll() throws SQLException {
        try(var connectionDB = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connectionDB.prepareStatement(SELECT_ALL_CART_PRODUCT_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<OrederToCart> cartProducts = new ArrayList<>();
            while (resultSet.next()) {
                OrederToCart orederToCart = new OrederToCart();
                orederToCart.setCartId(resultSet.getLong("cart_id"));
                orederToCart.setProductId(resultSet.getLong("product_id"));
                orederToCart.setQuantity(resultSet.getInt("quantity"));
                cartProducts.add(orederToCart);
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error retrieving all cart products", e);
        }
        return List.of();
    }
}
