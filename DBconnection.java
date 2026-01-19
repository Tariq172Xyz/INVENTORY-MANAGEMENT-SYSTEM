package inventorySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String url="jdbc:mysql://127.0.0.1:3306/inventory_and_sales_system";
    private static final String username="root";
    private static final String password="tariq";

        public  static Connection getconnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }



}
