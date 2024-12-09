package Repository;

import Model.Category;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProductRepository implements InitialFunctions<Product> {
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products (label, description, image, category, price, initial_Quantity, quantity_left, releasedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM products WHERE product_id = ?";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE products SET label = ?, description = ?, image = ?, category = ?, price = ?, initial_quantity = ?, quantity_left = ?, releasedDate = ? WHERE product_id = ?";
    private static final String SELECT_PRODUCT_BY_ID_SQL = "SELECT * FROM products WHERE product_id = ?";
    private static final String SELECT_ALL_PRODUCTS_SQL = "SELECT * FROM products";



    @Override
    public boolean add(Product product) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getLabel());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setString(4, product.getCategory().name());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setInt(6, product.getInitial_quantity());
            preparedStatement.setInt(7, product.getQuantity_left());
            preparedStatement.setObject(8, product.getReleasedDate());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding product: " + product.getLabel(), e);
        }
    }


    @Override
    public boolean delete(Long id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting product with id: " + id, e);
        }
    }

    @Override
    public boolean edit(Product product) throws SQLException {
        final int IDX_LABEL = 1;
        final int IDX_DESCRIPTION = 2;
        final int IDX_IMAGE = 3;
        final int IDX_CATEGORY = 4;
        final int IDX_PRICE = 5;
        final int IDX_INITIAL_QUANTITY = 6;
        final int IDX_QUANTITY_LEFT = 7;
        final int IDX_RELEASED_DATE = 8;
        final int IDX_PRODUCT_ID = 9;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            preparedStatement.setString(IDX_LABEL, product.getLabel());
            preparedStatement.setString(IDX_DESCRIPTION, product.getDescription());
            preparedStatement.setString(IDX_IMAGE, product.getImage());
            preparedStatement.setString(IDX_CATEGORY, product.getCategory().name());
            preparedStatement.setDouble(IDX_PRICE, product.getPrice());
            preparedStatement.setInt(IDX_INITIAL_QUANTITY, product.getInitial_quantity());
            preparedStatement.setInt(IDX_QUANTITY_LEFT, product.getQuantity_left());
            preparedStatement.setObject(IDX_RELEASED_DATE, product.getReleasedDate());
            preparedStatement.setLong(IDX_PRODUCT_ID, product.getProduct_id());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product: " + product.getLabel(), e);
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProduct_id(resultSet.getLong("product_id"));
                product.setLabel(resultSet.getString("label"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));
                product.setCategory(Category.valueOf(resultSet.getString("category"))); // Assuming Category is an enum
                product.setPrice(resultSet.getDouble("price"));
                product.setInitial_quantity(resultSet.getInt("initial_quantity"));
                product.setQuantity_left(resultSet.getInt("quantity_left"));
                product.setReleasedDate(resultSet.getObject("released_date", LocalDateTime.class));
                return Optional.of(product);
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductRepository.class.getName()).log(Level.SEVERE, "Error finding product with id: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProduct_id(resultSet.getLong("product_id"));
                product.setLabel(resultSet.getString("label"));
                product.setDescription(resultSet.getString("description"));
                product.setImage(resultSet.getString("image"));
                product.setCategory(Category.valueOf(resultSet.getString("category")));
                product.setPrice(resultSet.getDouble("price"));
                product.setInitial_quantity(resultSet.getInt("initial_quantity"));
                product.setQuantity_left(resultSet.getInt("quantity_left"));
                product.setReleasedDate(resultSet.getObject("releasedDate", LocalDateTime.class));
                // Consider adding userID to the Product model
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all products", e);
        }
    }
}



