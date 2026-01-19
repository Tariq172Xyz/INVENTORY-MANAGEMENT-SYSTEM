package inventorySystem;

import java.sql.*;
import java.util.List;

public class salesService {
    salesDAO saleDao=new salesDAO();
    productDAO productDao=new productDAO();

    public List<Sales> getSales(){
        List<Sales>getsales=saleDao.seeAllsales();

        if (getsales != null && !getsales.isEmpty()) {
            for (Sales s : getsales ) {
                System.out.println(
                     "Sales ID: "+ s.getSalesId() + " | " +
                     "Product ID: "+ s.getProductId() + " | " +
                     "Quantity Sold: " +s.getQuantitySold()+ " | " +
                     "Total Amount: " + s.getTotalAmount()+" | "+
                     "Sale Date: " +s.getSaleDate()
                );
            }
        }
        return getsales;
    }


   public void makeSale(int productId,int quantitySold){
       Product product=productDao.getProductbyId(productId);

       if (product==null ){
           System.out.println("Product does not exist");
           return;

       }else if( product.getQuantity()<quantitySold){
           System.out.println("not enough stock");
           return;
       }

       int totalAmount=quantitySold*product.getPrice();

       try (Connection connection =DBconnection.getconnection()){
           try {
               connection.setAutoCommit(false);

               saleDao.makeSale(productId,quantitySold,totalAmount,connection);
               productDao.updateQuantity(productId,product.getQuantity()-quantitySold,connection);

               connection.commit();
           }catch (SQLException e){
               connection.rollback();
               e.printStackTrace();
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
   }

   public void getBestSelling(){
        Sales s=saleDao.getBestSeller();
        if (s!=null){
            System.out.println(
                   "Product ID: " +s.getProductId() +" | "+
                   "Quantity Sold: " +s.getTotalAmount()+" | "+
                   "Total Amount: " +s.getQuantitySold()
            );

        }else {
            System.out.println("Products do not available");
        }
   }

}
