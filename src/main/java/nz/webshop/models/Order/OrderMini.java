package nz.webshop.models.Order;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderMini {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer Id;



   @Column (name = "customer_id")
    private Integer customerId;

    @Column(name = "datum")
    private String dateTime;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }





    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
