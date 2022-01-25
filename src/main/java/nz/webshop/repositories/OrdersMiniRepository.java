package nz.webshop.repositories;

import nz.webshop.models.Order.OrderMini;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersMiniRepository extends JpaRepository<OrderMini, Integer> {

}
