package nz.webshop.models.Order;


import nz.webshop.models.Product.*;

import java.util.List;


public class OrderMiniMax {


    private Integer Id;




    private Integer customerId;


    private String dateTime;

   private List<Products> products;

    public OrderMiniMax() {
    }

    public OrderMiniMax(Integer id, Integer customer_id, String dateTime, List<Products> products) {
        Id = id;
        this.customerId = customer_id;
        this.dateTime = dateTime;
        this.products = products;
    }


    // private List<OrderProduct> orderProduct;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
