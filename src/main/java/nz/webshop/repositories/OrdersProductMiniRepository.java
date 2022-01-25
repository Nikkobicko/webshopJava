package nz.webshop.repositories;

import nz.webshop.models.OrderProduct.OrderProductMini;
import nz.webshop.models.OrderProduct.OrderProductMiniID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersProductMiniRepository extends JpaRepository<OrderProductMini, OrderProductMiniID> {

  List<OrderProductMini> findByOrderid(Integer id);

}
