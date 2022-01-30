package nz.webshop.repositories;

import nz.webshop.models.Customer.Password;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PasswordRepository extends JpaRepository<Password, Integer> {

}
