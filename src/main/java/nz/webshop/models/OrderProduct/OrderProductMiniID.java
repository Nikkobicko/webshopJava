package nz.webshop.models.OrderProduct;

import java.io.Serializable;


public class OrderProductMiniID implements Serializable {


    private Integer orderid;


    private Integer productid;


    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
