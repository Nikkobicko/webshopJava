package nz.webshop.models.Order;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

import nz.webshop.models.Product.*;


public class OrderDTOToClient {


    private Integer Id;




    private Integer customerId;


    private String dateTime;

   private List<Products> products;

    public OrderDTOToClient() {
    }

    public OrderDTOToClient(Integer id, Integer customerId, String dateTime, List<Products> products) {
        Id = id;
        this.customerId = customerId;
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
