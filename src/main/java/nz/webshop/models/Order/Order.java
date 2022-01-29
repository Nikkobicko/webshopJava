package nz.webshop.models.Order;


import com.fasterxml.jackson.annotation.JsonBackReference;
import nz.webshop.models.Customer.CustomerNoPasswordOrders;
import nz.webshop.models.OrderProduct.OrderProduct;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer Id;


 //  @ManyToOne(targetEntity=CustomerNoPasswordOrders.class)
 //@JoinColumn (name = "customer_id")
// @ManyToOne(fetch = FetchType.EAGER)

/*  @Column(name = "customer_id")
  private Integer customerId;*/
/*
public Order() {

}

    public Order(Integer id, CustomerNoPasswordOrders customer, String dateTime) {
    Id = id;
    this.customer = customer;
    this.dateTime = dateTime;
}
*/



    public CustomerNoPasswordOrders getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerNoPasswordOrders customer) {
        this.customer = customer;
    }
  //  @JoinColumn(name = "customer_id", referencedColumnName="customer_id")
    @ManyToOne(targetEntity=CustomerNoPasswordOrders.class)
     @JsonBackReference
    @JoinColumn(name = "customer_id", referencedColumnName="customer_id")
   private CustomerNoPasswordOrders customer;


   @Column(name = "datum")
    private String dateTime;


   @OneToMany(targetEntity = OrderProduct.class, mappedBy = "orderId")
   private List<OrderProduct> products;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }





    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> orderProduct) {
        this.products = orderProduct;
    }

/*  public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }*/

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
