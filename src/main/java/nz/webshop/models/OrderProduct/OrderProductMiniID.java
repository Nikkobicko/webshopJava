package nz.webshop.models.OrderProduct;

import java.io.Serializable;


public class OrderProductMiniID implements Serializable {


    private Integer orderId;


    private Integer productid;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderid) {
        this.orderId = orderid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
