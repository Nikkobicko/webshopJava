package nz.webshop.models.Order;


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


   @ManyToOne(targetEntity=CustomerNoPasswordOrders.class)
        //@JoinColumn (name = "customer_id", referencedColumnName="customerId")
    @JoinColumn (name = "customer_id")
   //@Column (name = "customer_id")
    private Integer customer_id;

    @Column(name = "datum")
    private String dateTime;

   // private List<Products> products;

   @OneToMany(targetEntity = OrderProduct.class, mappedBy = "order_id")
   private List<OrderProduct> orderProduct;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }





    public List<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
