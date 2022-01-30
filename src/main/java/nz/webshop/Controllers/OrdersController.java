package nz.webshop.Controllers;

import nz.webshop.Services.OrderServices;
import nz.webshop.models.Order.Order;
import nz.webshop.models.Order.OrderDTOFromClient;
import nz.webshop.models.Order.OrderDTOToClient;
import nz.webshop.models.OrderProduct.OrderProduct;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersProductRepository ordersProductRepository;


    @Autowired
    OrderServices orderServices;


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addOne(@RequestBody OrderDTOFromClient orderDTOFromClient) {
        orderServices.addOneOrder(orderDTOFromClient);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getAll() {
        return ordersRepository.findAll();
    }

    @RequestMapping(value = "/orderproduct", method = RequestMethod.GET)
    public List<OrderProduct> getAll1() {
        return ordersProductRepository.findAll();
    }

    @RequestMapping(value = "/orderall", method = RequestMethod.GET)
    public List<Order> getAll2() {
        List<Order> orderMaxeList = orderServices.getOrdersList();
        return orderMaxeList;
    }

    @RequestMapping(value = "/order/customer/{id}", method = RequestMethod.GET)
    public List<OrderDTOToClient> getOrdersByCustomer(@PathVariable("id") Integer id) {
        List<OrderDTOToClient> orderMaxeListId = orderServices.getOrderListId(id);
        return orderMaxeListId;
    }


    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public OrderDTOToClient getOneOrder(@PathVariable("id") Integer id) {
        OrderDTOToClient order = orderServices.getOrderOne(id);
        return order;
    }

}
