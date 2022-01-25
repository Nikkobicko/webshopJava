package nz.webshop.Controllers;

import nz.webshop.Servers.OrderServices;
import nz.webshop.models.Order.OrderFromJSON;
import nz.webshop.models.Order.OrderMini;
import nz.webshop.models.Order.OrderMiniMax;
import nz.webshop.models.OrderProduct.OrderProductMini;
import nz.webshop.models.Product.ProductMini;
import nz.webshop.models.Product.Products;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class OrdersController {

    @Autowired
    OrdersMiniRepository ordersMiniRepository;

    @Autowired
    OrdersProductMiniRepository ordersProductMiniRepository;


    @Autowired
    OrderServices orderServices;


    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderMini addOne(@RequestBody OrderFromJSON orderFromJSON) {
        OrderMini order1 = orderServices.addOneOrder(orderFromJSON);

        return order1;
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<OrderMini> getAll() {
        return ordersMiniRepository.findAll();
    }

    @RequestMapping(value = "/orderproduct", method = RequestMethod.GET)
    public List<OrderProductMini> getAll1() {
        return ordersProductMiniRepository.findAll();
    }

    @RequestMapping(value = "/orderall", method = RequestMethod.GET)
    public List<OrderMiniMax> getAll2() {
        ArrayList<OrderMiniMax> orderMiniMaxeList = orderServices.getMiniMaxeList();
        return orderMiniMaxeList;
    }

    @RequestMapping(value = "/order/customer/{id}", method = RequestMethod.GET)
    public List<OrderMiniMax> getOrdersByCustomer(@PathVariable("id") Integer id) {
        ArrayList<OrderMiniMax> orderMiniMaxeListId = orderServices.getMiniMaxeListId(id);
        return orderMiniMaxeListId;
    }


    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public OrderMiniMax getOneOrder(@PathVariable("id") Integer id) {
        OrderMiniMax orderMiniMax = orderServices.getMiniMaxeOne(id);


        return orderMiniMax;
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
