package nz.webshop.models.Order;


import java.util.List;

import nz.webshop.models.Product.*;

public class OrderDTOFromClient {

    private Integer customerId;

    private List<ProductsDTO> products;

    public OrderDTOFromClient() {
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
}
