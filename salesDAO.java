package inventorySystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class salesDAO {

    public List<Sales> seeAllsales(){
        List<Sales>sales=new ArrayList<>();
        String query="SELECT * FROM SALES";
        try(Connection connection=DBconnection.getconnection()) {
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                    Sales s= new Sales(resultSet.getInt("salesId"),
                            resultSet.getInt("productId"),
                            resultSet.getInt("quantitySold"),
                            resultSet.getDate("saleDate"),
                            resultSet.getInt("totalAmount"));
                    sales.add(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sales;
    }


    public void makeSale(int productId,int quantitySold,int totalAmount,Connection connection){
        String query="INSERT INTO sales (productId,quantitySold,totalAmount) VALUES(?,?,?)";

        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){

            preparedStatement.setInt(1,productId);
            preparedStatement.setInt(2,quantitySold);
            preparedStatement.setInt(3,totalAmount);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Sales getBestSeller() {

        String query = "SELECT productId,SUM(totalAmount) As amount_sold,SUM(quantitySold) AS total_sold FROM sales GROUP BY productId ORDER BY total_sold DESC LIMIT 1";

        try (Connection connection = DBconnection.getconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                Sales s= new Sales(resultSet.getInt("productId"),
                        resultSet.getInt("amount_sold"),//amount of product that sold
                        resultSet.getInt("total_sold"));//quantity/no of products sold

                return s;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



}
