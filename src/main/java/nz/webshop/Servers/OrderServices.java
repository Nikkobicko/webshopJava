package nz.webshop.Servers;

import nz.webshop.models.Customer.CustomerNoPasswordOrders;
import nz.webshop.models.Order.Order;
import nz.webshop.models.Order.OrderFromClient;
import nz.webshop.models.Order.OrderDTOToClient;
import nz.webshop.models.OrderProduct.OrderProduct;
import nz.webshop.models.OrderProduct.OrderProductMini;
import nz.webshop.models.Product.ProductMini;
import nz.webshop.models.Product.Products;
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
    OrdersRepository ordersMiniRepository;
    @Autowired
    OrdersRepository ordersRepository;


    @Autowired
    OrdersProductMiniRepository ordersProductMiniRepository;
    @Autowired
    OrdersProductRepository ordersProductRepository;

    @Autowired
    ProductMiniRepository productMiniRepository;

    @Autowired
    CustomerRepositoryNoPassword customerRepositoryNoPassword;

    @Autowired
    CustomerNoPasswordOrdersRepositry customerNoPasswordOrdersRepositry;



    public void addOneOrder(OrderFromClient orderFromClient) {
        Order order1 = new Order();
     CustomerNoPasswordOrders customer = customerNoPasswordOrdersRepositry.getCustomerByCustomerId(orderFromClient.getCustomerId());
       //order1.setCustomer(orderFromJSON.getCustomerId());
        order1.setCustomer(customer);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order1.setDateTime(sdf.format(new Date()));

      ordersRepository.save(order1);

        List<Products> products = orderFromClient.getProducts();

       for (Products pp : products) {
            OrderProductMini opm = new OrderProductMini();
            opm.setOrderId(order1.getId());
            System.out.println("orderprodict orgerId: " + opm.getOrderId());
            opm.setProductid(pp.getProductId());
            System.out.println("orderprodict productId: " + opm.getProductid());
            opm.setQuantity(pp.getQuantity());
            //make reducing products in stock
            ProductMini pm = productMiniRepository.getById(pp.getProductId());
            pm.setUnitsInStock((pm.getUnitsInStock()) - (pp.getQuantity()));
            ordersProductMiniRepository.save(opm);

        }
      //return order1;
       // return new ResponseEntity(HttpStatus.OK);
    }

/*    public ArrayList<OrderMiniMax> getMiniMaxeList() {
        ArrayList<OrderMiniMax> orderMiniMaxeList = new ArrayList<>();

      List<Order> orderMinis = ordersMiniRepository.findAll();
        for (Order om : orderMinis) {
            ordersAddList(orderMiniMaxeList, om);
        }
        return orderMiniMaxeList;
    }*/

    public List<Order> getMiniMaxeList() {
        List<Order> orderMinis = ordersRepository.findAll();
        return orderMinis;
    }

    public ArrayList<OrderDTOToClient> getMiniMaxeListId(Integer id) {
        ArrayList<OrderDTOToClient> orderMiniMaxeListId = new ArrayList<>();
        CustomerNoPasswordOrders customer = customerNoPasswordOrdersRepositry.getCustomerByCustomerId(id);
      List<Order> orderMinis = customer.getOrder();
//Order testOrder = new Order(22,customer, "575758uuit");
//ordersMiniRepository.save(testOrder);
//orderMinis.add(testOrder);
        for (Order om : orderMinis) {
            ordersAddList(orderMiniMaxeListId, om);
        }
        return orderMiniMaxeListId;
    }

    public OrderDTOToClient getMiniMaxeOne(Integer id) {

        Order orderMini = ordersRepository.getById(id);

       // List<OrderProductMini> productsList = ordersProductMiniRepository.getOrderProductMinisByOrderid(id);
        List<OrderProduct> productsList = orderMini.getProducts();
        ArrayList<Products> products = new ArrayList<>();


      //  orderMini.setProducts(orderProducts);

   for (OrderProduct opm : productsList) {
            products.add(new Products(opm.getProductId().getId(), opm.getQuantity()));
        }
       Integer customerId = orderMini.getCustomer().getCustomerId();
      //  OrderMiniMax orderMiniMax = new OrderMiniMax(orderMini.getId(), orderMini.getCustomerId(), orderMini.getDateTime(), products);
      OrderDTOToClient orderDTOToClient = new OrderDTOToClient(orderMini.getId(), customerId, orderMini.getDateTime(), products);
        return orderDTOToClient;
    }

    private void ordersAddList(ArrayList<OrderDTOToClient> orderMiniMaxeListId, Order om) {

        Integer index = om.getId();
        List<OrderProductMini> productsList = ordersProductMiniRepository.getOrderProductMinisByOrderId(index);
        ArrayList<Products> products = new ArrayList<>();

        for (OrderProductMini opm : productsList) {
            products.add(new Products(opm.getProductid(), opm.getQuantity()));
        }
        Integer customerId = om.getCustomer().getCustomerId();
       orderMiniMaxeListId.add(new OrderDTOToClient(om.getId(), customerId, om.getDateTime(), products));

    }
}
