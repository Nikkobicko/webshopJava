package nz.webshop.models.OrderProduct;


import javax.persistence.*;

@Entity
@Table(name = "orderproduct")
@IdClass(OrderProductMiniID.class)
public class OrderProductMini {

    @Id
    @Column(name = "order_id")
    //@ManyToOne(targetEntity=Order.class)
   // @JoinColumn (name = "orderid")
    private Integer orderid;

    @Id
   @Column(name = "product_id")
    //@ManyToOne(targetEntity=Product.class)
   // @JoinColumn (name = "productid")
    private Integer productid;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderProductMini(Integer orderid, Integer product, Integer quantity) {
        this.orderid = orderid;
        this.productid = product;
        this.quantity = quantity;
    }

    public OrderProductMini() {
    }


    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
