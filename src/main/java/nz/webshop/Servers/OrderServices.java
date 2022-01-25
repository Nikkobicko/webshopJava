package nz.webshop.Servers;

import nz.webshop.models.Order.OrderFromJSON;
import nz.webshop.models.Order.OrderMini;
import nz.webshop.models.Order.OrderMiniMax;
import nz.webshop.models.OrderProduct.OrderProductMini;
import nz.webshop.models.Product.ProductMini;
import nz.webshop.models.Product.Products;
import nz.webshop.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServices {

    @Autowired
    OrdersMiniRepository ordersMiniRepository;

    @Autowired
    OrdersProductMiniRepository ordersProductMiniRepository;

    @Autowired
    ProductMiniRepository productMiniRepository;



    public OrderMini addOneOrder(OrderFromJSON orderFromJSON) {
        OrderMini order1 = new OrderMini();
        order1.setCustomerId(orderFromJSON.getCustomerId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order1.setDateTime(sdf.format(new Date()));

        ordersMiniRepository.save(order1);

        List<Products> products = orderFromJSON.getProducts();

        for (Products pp : products) {
            OrderProductMini opm = new OrderProductMini();
            opm.setOrderid(order1.getId());
            System.out.println("orderprodict orgerId: " + opm.getOrderid());
            opm.setProductid(pp.getProductId());
            System.out.println("orderprodict productId: " + opm.getProductid());
            opm.setQuantity(pp.getQuantity());
            //make reducing products in stock
            ProductMini pm = productMiniRepository.getById(pp.getProductId());
            pm.setUnitsInStock((pm.getUnitsInStock()) - (pp.getQuantity()));
            ordersProductMiniRepository.save(opm);

        }
        return order1;
    }

    public ArrayList<OrderMiniMax> getMiniMaxeList() {
        ArrayList<OrderMiniMax> orderMiniMaxeList = new ArrayList<>();

        List<OrderMini> orderMinis = ordersMiniRepository.findAll();
        for (OrderMini om : orderMinis) {
            ordersAddList(orderMiniMaxeList, om);
        }
        return orderMiniMaxeList;
    }

    public ArrayList<OrderMiniMax> getMiniMaxeListId(Integer id) {
        ArrayList<OrderMiniMax> orderMiniMaxeListId = new ArrayList<>();

        List<OrderMini> orderMinis = ordersMiniRepository.findAll();
        for (OrderMini om : orderMinis) {
            if (om.getCustomerId() == id) {
                ordersAddList(orderMiniMaxeListId, om);

            }
        }
        return orderMiniMaxeListId;
    }

    public OrderMiniMax getMiniMaxeOne(Integer id) {

        OrderMini orderMini = ordersMiniRepository.getById(id);
        List<OrderProductMini> productsList = ordersProductMiniRepository.findByOrderid(id);
        ArrayList<Products> products = new ArrayList<>();

        for (OrderProductMini opm : productsList) {
            products.add(new Products(opm.getProductid(), opm.getQuantity()));
        }
        OrderMiniMax orderMiniMax = new OrderMiniMax(orderMini.getId(), orderMini.getCustomerId(), orderMini.getDateTime(), products);

       ModelMapper modelMapper = new ModelMapper();
// user here is a prepopulated User instance
        //UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return orderMiniMax;
    }

    private void ordersAddList(ArrayList<OrderMiniMax> orderMiniMaxeListId, OrderMini om) {

        Integer index = om.getId();
        List<OrderProductMini> productsList = ordersProductMiniRepository.findByOrderid(index);
        ArrayList<Products> products = new ArrayList<>();

        for (OrderProductMini opm : productsList) {
            products.add(new Products(opm.getProductid(), opm.getQuantity()));
        }
        orderMiniMaxeListId.add(new OrderMiniMax(om.getId(), om.getCustomerId(), om.getDateTime(), products));

    }
}
