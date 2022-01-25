package nz.webshop.repositories;

import nz.webshop.models.OrderProduct.OrderProduct;
import nz.webshop.models.OrderProduct.OrderProductID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersProductRepository extends JpaRepository<OrderProduct, OrderProductID> {

}
