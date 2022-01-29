package nz.webshop.models.Customer;


public class Customer extends CustomerNoPassword {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

public Customer(){};

    public Customer(String password, String firstName, String lastName, String email,
            String phone, String address, String postalCode, String city){
        super(firstName, lastName,  email,
                phone,  address,  postalCode,  city);
        this.password = password;
    }

}








