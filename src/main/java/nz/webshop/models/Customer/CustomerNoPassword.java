package nz.webshop.models.Customer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import nz.webshop.models.Order.Order;

import javax.persistence.*;
import java.util.List;

//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
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
    //@OneToOne (targetEntity = Password.class, mappedBy = "customer")
  //  @JsonManagedReference (value="customer-password")
    @OneToOne ( targetEntity = Password.class, mappedBy = "customer")
    private Password passwordEntity;

    //  @JsonManagedReference (value="customer-order")
    @OneToMany(targetEntity = Order.class, mappedBy = "customer")
    private List<Order> Order;



    public Password getPasswordEntity() {
        return passwordEntity;
    }

    public void setPasswordEntity(Password password) {
        this.passwordEntity = password;
    }

    public List<nz.webshop.models.Order.Order> getOrder() {
        return Order;
    }

    public void setOrder(List<nz.webshop.models.Order.Order> order) {
        Order = order;
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





}
