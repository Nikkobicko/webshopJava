package nz.webshop.repositories;

import nz.webshop.models.Order.Order;
import nz.webshop.models.OrderProduct.OrderProduct;
import nz.webshop.models.OrderProduct.OrderProductID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersProductRepository extends JpaRepository<OrderProduct, OrderProductID> {

    List<OrderProduct> getOrderProductsByOrderId(Integer id);
    List<OrderProduct> getOrderProductsByOrderIdAndProductId (Integer orderId, Integer productId);
    List<OrderProduct> getOrderProductsByOrderId (Order order);
}
