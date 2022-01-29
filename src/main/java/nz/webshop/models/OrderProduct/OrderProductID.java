package nz.webshop.models.OrderProduct;

import java.io.Serializable;


public class OrderProductID implements Serializable {


    private Integer orderId;


    private Integer productId;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
