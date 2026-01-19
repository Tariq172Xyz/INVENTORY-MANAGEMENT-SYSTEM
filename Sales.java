package inventorySystem;

import java.sql.Date;

public class Sales {


    private int salesId;
    private int productId;
    private int quantitySold;
    private Date saleDate;
    private int totalAmount;


    //to fetch sales data from Db
    public Sales(int salesId, int productId, int quantitySold, Date saleDate, int totalAmount) {
        this.salesId = salesId;
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    //to insert sales data in db
    public Sales(int productId, int quantitySold, Date saleDate, int totalAmount) {
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }
    public Sales(int productId, int quantitySold, int totalAmount) {
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.totalAmount = totalAmount;
    }

    public int getSalesId() {
        return salesId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
