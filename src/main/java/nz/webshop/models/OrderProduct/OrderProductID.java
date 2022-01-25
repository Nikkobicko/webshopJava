package nz.webshop.models.OrderProduct;

import java.io.Serializable;


public class OrderProductID implements Serializable {


    private Integer order_id;


    private Integer product_id;


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }


    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
