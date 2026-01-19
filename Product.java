package inventorySystem;

public class Product {
    private int productId;
    private String productName;
    private int price;
    private int quantity;

    public Product(){

    }
    public Product(int productId, String productName, int price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addstock(int newQuantity){
        quantity+=newQuantity;
    }

    public void reduceStock(int newQuantity){
        quantity-=newQuantity;
    }
}
