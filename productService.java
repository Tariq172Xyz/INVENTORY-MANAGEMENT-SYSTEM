package inventorySystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class productService {
    productDAO productDao=new productDAO();


    public void addProduct(Product product){
        if (product.getPrice()<=0 || product.getQuantity()<0){
            System.out.println("invalid price or quantiy ");
        }else {
            productDao.addProduct(product);
            System.out.println("Product Added");

        }
    }

    public void deleteProduct(int productId){
       Product product=productDao.getProductbyId(productId);
       if (product!=null){
           productDao.deleteProduct(productId);
           System.out.println("Product deleted");
       }else{
           System.out.println("Product does not exist! ");
       }

    }

    public void updateProduct(int productId,int quantity){

        try (Connection connection=DBconnection.getconnection()){
            Product product=productDao.getProductbyId(productId);
            if (product!=null){
                productDao.updateQuantity(productId,quantity,connection);
                System.out.println("Product updated");

            }else {
                System.out.println("Product does not exist");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }



    }
    public List<Product> seeAllProducts(){
       List<Product>products =productDao.viewProducts();

        if (products != null && !products.isEmpty()) {
            for (Product p : products) {
                System.out.println(
                       "Product ID: " +p.getProductId() + " | " +
                       "Product Name: " + p.getProductName() + " | " +
                       "Price: " + p.getPrice() + " | " +
                       "Quantity: " + p.getQuantity()
                );
            }
        }
        return products;
    }
}
