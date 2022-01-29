package nz.webshop.repositories;

import nz.webshop.models.Customer.Password;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PasswordRepository extends JpaRepository<Password, Integer> {

    // void save(OrderMini order1);
    //List <Order> getByCustomerId(Integer customerId);
   // List <Order> getOrdersByCustomerId(Integer id);
    //List <Order> getByCustomerId(Integer customerId);
   // List <Order> getOrdersByCustomerId(Integer id);

}
