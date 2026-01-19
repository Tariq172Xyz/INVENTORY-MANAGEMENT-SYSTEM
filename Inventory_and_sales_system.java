package inventorySystem;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Inventory_and_sales_system {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        productService productservice=new productService();
        userService userservice=new userService();
        salesService salesservice=new salesService();


            System.out.println("#*#*#*#*#* Welcome to Inventory And Sales System #*#*#*#*#*");
            System.out.println("Login");
            System.out.println();
            System.out.println("Enter email: ");
            String email= sc.nextLine();
            System.out.println("Enter password: ");
            String password=sc.nextLine();

            if (!userservice.login(email,password)){
                System.out.println("Invalid Login");
                return;
            }
            System.out.println("Login Successfull");
            while (true){
                System.out.println("1.Add product");
                System.out.println("2.Delete Product");
                System.out.println("3.Update Product");
                System.out.println("4.View Products");
                System.out.println("5.see the best selling product");
                System.out.println("6. Make Sale");
                System.out.println("7.See all the sales");
                System.out.println("8.Logout");
                System.out.print("Enter choice: ");
                int choice =sc.nextInt();
                switch (choice){
                    case 1 ->{
                        sc.nextLine();
                        System.out.println("Enter product name: ");
                        String name=sc.nextLine();
                        System.out.println("Enter product price: ");
                        int price=sc.nextInt();
                        System.out.println("Enter quantity: ");
                        int quantity=sc.nextInt();
                        productservice.addProduct(new Product(name,price,quantity));

                    }
                    case 2 ->{
                        System.out.println("Enter product ID: ");
                        int productid=sc.nextInt();
                        productservice.deleteProduct(productid);
                    }
                    case 3 ->{
                        System.out.println("Enter product ID: ");
                        int productid=sc.nextInt();
                        System.out.println("Enter new quantity");
                        int quantity=sc.nextInt();
                        productservice.updateProduct(productid,quantity);
                    }
                    case 4 ->{
                        productservice.seeAllProducts();
                    }
                    case 5 ->{
                        salesservice.getBestSelling();

                    }
                    case 6 ->{
                        System.out.println("Enter Product ID: ");
                        int productId=sc.nextInt();
                        System.out.println("Enter quantity sold: ");
                        int quantitySold=sc.nextInt();
                        salesservice.makeSale(productId,quantitySold);
                    }
                    case 7 ->{
                       salesservice.getSales();
                    }
                    case 8 ->{
                        System.out.println("Logging out! ");
                        return;
                    }
            }

            }
        }
}
