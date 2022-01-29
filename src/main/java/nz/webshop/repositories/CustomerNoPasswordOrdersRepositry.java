package nz.webshop.repositories;

import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.models.Customer.CustomerNoPasswordOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerNoPasswordOrdersRepositry extends JpaRepository<CustomerNoPasswordOrders, Integer> {
    CustomerNoPasswordOrders getCustomerByCustomerId (Integer id);


}

