package nz.webshop.repositories;

import nz.webshop.models.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
