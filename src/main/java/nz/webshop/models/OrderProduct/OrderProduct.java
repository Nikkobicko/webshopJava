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
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order orderId;

    @Id
    // @Column(name = "product_id")
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderProduct(Order orderId, Product product, Integer quantity) {
        this.orderId = orderId;
        this.productId = product;
        this.quantity = quantity;
    }

    public OrderProduct() {
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order order) {
        this.orderId = order;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product product) {
        this.productId = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


