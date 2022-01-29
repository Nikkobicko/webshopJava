package nz.webshop.models.Customer;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table (name ="customer")
public class CustomerNoPassword {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    private String phone;
    private String address;
    @Column(name = "postal_code")
    private String postalCode;
    private String city;

    //@OneToOne (targetEntity = Password.class, mappedBy = "customer")
    @JsonManagedReference
    @OneToOne ( targetEntity = Password.class, mappedBy = "customer")
    private Password passwordEntity;

    public Password getPasswordEntity() {
        return passwordEntity;
    }

    public void setPasswordEntity(Password password) {
        this.passwordEntity = password;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public CustomerNoPassword() {
    }

    public CustomerNoPassword(String firstName, String lastName, String email,
                              String phone, String address, String postalCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.phone = phone;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }
    public void setCustomerNoPassword(String firstName, String lastName, String email,
                           String phone, String address, String postalCode, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.phone = phone;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

}
