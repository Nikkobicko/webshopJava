package nz.webshop.repositories;

import nz.webshop.models.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findCustomerByEmailAndPassword( String email, String password);
    Customer findByEmail (String email);
}
