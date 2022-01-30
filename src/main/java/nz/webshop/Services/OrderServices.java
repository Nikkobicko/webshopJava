package nz.webshop.Services;

import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.models.Order.Order;
import nz.webshop.models.Order.OrderDTOFromClient;
import nz.webshop.models.Order.OrderDTOToClient;
import nz.webshop.models.OrderProduct.OrderProduct;
import nz.webshop.models.Product.Product;
import nz.webshop.models.Product.ProductsDTO;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServices {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersProductRepository ordersProductRepository;


    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerNoPasswordRepository customerNoPasswordRepository;


    public void addOneOrder(OrderDTOFromClient orderDTOFromClient) {
        Order order1 = new Order();
     CustomerNoPassword customer = customerNoPasswordRepository.getCustomerByCustomerId(orderDTOFromClient.getCustomerId());
       //order1.setCustomer(orderFromJSON.getCustomerId());
        order1.setCustomer(customer);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order1.setDateTime(sdf.format(new Date()));

      ordersRepository.save(order1);

        List<ProductsDTO> products = orderDTOFromClient.getProducts();

        for (ProductsDTO pp : products) {
            OrderProduct opm = new OrderProduct();
            opm.setOrderId(order1);
            Product pEnt = productRepository.getById(pp.getProductId());
            opm.setProductId(pEnt);
            opm.setQuantity(pp.getQuantity());
            //make reducing products in stock
            pEnt.setUnitsInStock((pEnt.getUnitsInStock()) - (pp.getQuantity()));
            ordersProductRepository.save(opm);
        }
      //return order1;
       // return new ResponseEntity(HttpStatus.OK);
    }



    public List<Order> getOrdersList() {
        List<Order> orders = ordersRepository.findAll();
        return orders;
    }

    public ArrayList<OrderDTOToClient> getOrderListId(Integer id) {
        ArrayList<OrderDTOToClient> orderOrderListId = new ArrayList<>();
        CustomerNoPassword customer = customerNoPasswordRepository.getCustomerByCustomerId(id);
      List<Order> orders = customer.getOrder();

        for (Order om : orders) {
            ordersAddList(orderOrderListId, om);
        }
        return orderOrderListId;
    }

    public OrderDTOToClient getOrderOne(Integer id) {

        Order order = ordersRepository.getById(id);


        List<OrderProduct> productsList = order.getProducts();
        ArrayList<ProductsDTO> products = new ArrayList<>();




   for (OrderProduct opm : productsList) {
            products.add(new ProductsDTO(opm.getProductId().getId(), opm.getQuantity()));
        }
       Integer customerId = order.getCustomer().getCustomerId();

      OrderDTOToClient orderDTOToClient = new OrderDTOToClient(order.getId(), customerId, order.getDateTime(), products);
        return orderDTOToClient;
    }

    private void ordersAddList(ArrayList<OrderDTOToClient> orderOrderDTOListId, Order om) {

       // Integer index = om.getId();
        List<OrderProduct> productsList = ordersProductRepository.getOrderProductsByOrderId(om);
        ArrayList<ProductsDTO> products = new ArrayList<>();

        for (OrderProduct opm : productsList) {
            products.add(new ProductsDTO(opm.getProductId().getId(), opm.getQuantity()));
        }
        Integer customerId = om.getCustomer().getCustomerId();
       orderOrderDTOListId.add(new OrderDTOToClient(om.getId(), customerId, om.getDateTime(), products));

    }
}
