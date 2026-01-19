package inventorySystem;

public class userService {

    private String email="email";
    private String password="pass";

    public boolean login(String Email,String Password){
    return email.equals(Email)&& password.equals(Password);


   }

}
