package inventorySystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDAO {

    public void addProduct(Product product) {
        String query = "INSERT INTO product (productName,price,quantity) VALUES(?,?,?)";

        try (Connection connection = DBconnection.getconnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        String query = "DELETE FROM product WHERE productId=?";

        try (Connection connection = DBconnection.getconnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //to add/remove quantity
    public void updateQuantity(int productId, int quantity, Connection connection) {
        String query = "UPDATE product SET quantity=? WHERE productId=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //just to check whether the product exist or not
    public Product getProductbyId(int productId) {
        String query = "SELECT * FROM product WHERE productId=?";

        try (Connection connection = DBconnection.getconnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Product(resultSet.getInt("productId"),
                        resultSet.getString("productName"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> viewProducts() {
        List<Product> productList = new ArrayList<>();

        String query = "SELECT * from product";
        try (Connection connection = DBconnection.getconnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product p = new Product(resultSet.getInt("productId"),
                        resultSet.getString("productName"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"));

                productList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }


}