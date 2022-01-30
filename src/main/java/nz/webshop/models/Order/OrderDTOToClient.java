package nz.webshop.models.Order;


import java.util.List;

import nz.webshop.models.Product.*;

public class OrderDTOToClient {

    private Integer Id;
    private Integer customerId;
    private String dateTime;

    private List<ProductsDTO> products;

    public OrderDTOToClient() {
    }

    public OrderDTOToClient(Integer id, Integer customerId, String dateTime, List<ProductsDTO> products) {
        Id = id;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.products = products;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<ProductsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsDTO> products) {
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
