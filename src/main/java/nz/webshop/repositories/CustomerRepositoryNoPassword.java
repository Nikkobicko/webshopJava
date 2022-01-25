package nz.webshop.repositories;

import nz.webshop.models.Customer.CustomerNoPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositoryNoPassword extends JpaRepository<CustomerNoPassword, Integer> {

}

