package nz.webshop.models.OrderProduct;


import nz.webshop.models.Order.Order;
import nz.webshop.models.Product.Product;

import javax.persistence.*;

@Entity
@Table(name = "orderproduct")
@IdClass(OrderProductID.class)
public class OrderProduct {

    @Id
    //@Column(name = "order_id")
    @ManyToOne(targetEntity=Order.class)
    @JoinColumn (name = "order_id")
    private Integer order_id;

    @Id
   // @Column(name = "product_id")
    @ManyToOne(targetEntity=Product.class)
    @JoinColumn (name = "product_id")
    private Integer product_id;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderProduct(Integer order_id, Integer product, Integer quantity) {
        this.order_id = order_id;
        this.product_id = product;
        this.quantity = quantity;
    }

    public OrderProduct() {
    }


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
