package nz.webshop.models.Order;


import java.util.Date;
import java.util.List;

import nz.webshop.models.Product.*;

public class OrderFromJSON {

    private Integer customerId;

    private List<Products> products;

    public OrderFromJSON() {
    }




    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
