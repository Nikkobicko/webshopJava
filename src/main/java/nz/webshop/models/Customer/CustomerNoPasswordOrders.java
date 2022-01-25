package nz.webshop.models.Customer;


import nz.webshop.models.Order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name ="customer")
public class CustomerNoPasswordOrders {
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

@OneToMany(targetEntity = nz.webshop.models.Order.Order.class, mappedBy = "customer_id")
         //@OneToMany(mappedBy = "customer")
  private List<Order> Order;


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

  public List<nz.webshop.models.Order.Order> getOrder() {
        return Order;
    }

    public void setOrder(List<nz.webshop.models.Order.Order> order) {
        Order = order;
    }
}
