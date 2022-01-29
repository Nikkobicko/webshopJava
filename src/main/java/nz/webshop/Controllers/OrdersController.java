package nz.webshop.Controllers;

import nz.webshop.Servers.OrderServices;
import nz.webshop.models.Order.Order;
import nz.webshop.models.Order.OrderFromClient;
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
    OrdersProductRepository ordersProductMiniRepository;


    @Autowired
    OrderServices orderServices;


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addOne(@RequestBody OrderFromClient orderFromClient) {
        orderServices.addOneOrder(orderFromClient);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getAll() {
        return ordersRepository.findAll();
    }

    @RequestMapping(value = "/orderproduct", method = RequestMethod.GET)
    public List<OrderProduct> getAll1() {
        return ordersProductMiniRepository.findAll();
    }

    @RequestMapping(value = "/orderall", method = RequestMethod.GET)
    //public List<OrderMiniMax> getAll2() {
        public List<Order> getAll2() {
        //ArrayList<OrderMiniMax> orderMiniMaxeList = orderServices.getMiniMaxeList();
       List<Order> orderMiniMaxeList = orderServices.getMiniMaxeList();
        return orderMiniMaxeList;
    }

    @RequestMapping(value = "/order/customer/{id}", method = RequestMethod.GET)
    public List<OrderDTOToClient> getOrdersByCustomer(@PathVariable("id") Integer id) {
        List<OrderDTOToClient> orderMiniMaxeListId = orderServices.getMiniMaxeListId(id);
        return orderMiniMaxeListId;
    }


    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
  //  public OrderMiniMax getOneOrder(@PathVariable("id") Integer id) {
        public OrderDTOToClient getOneOrder(@PathVariable("id") Integer id) {
     //   OrderMiniMax order = orderServices.getMiniMaxeOne(id);
        OrderDTOToClient order = orderServices.getMiniMaxeOne(id);
        return order;
    }



     /*   @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order addOne (@RequestBody Order order) {
      List<OrderProduct> orderProducts=new ArrayList<>();
        List<Products> products= order.getProducts();
        //if list is not null...
       for (Products ps:products){
           OrderProduct orderProduct= new OrderProduct(order.getId(), ps.getProductId(), ps.getQuantity() );
           orderProducts.add(orderProduct);
       }
       ordersProductRepository.save(orderProducts);
        return order;
    }*/


    //make reducing products in stock
//ordersProductMiniRepository.save(opm);

    //List<OrderProduct> orderProducts=new ArrayList<>();
    // List<OrderProduct> products= order.getOrderProduct();
    //if list is not null...

        /* for (OrderProduct ps:products){
            OrderProduct orderProduct= new OrderProduct(order.getId(), ps.getProductId(), ps.getQuantity() );
            orderProducts.add(orderProduct);
        }*/
    //  ordersProductRepository.save(products);
}
