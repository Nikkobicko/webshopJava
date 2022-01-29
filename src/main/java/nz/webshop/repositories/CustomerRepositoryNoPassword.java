package nz.webshop.repositories;

import nz.webshop.models.Customer.Customer;
import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.models.Customer.CustomerNoPasswordOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepositoryNoPassword extends JpaRepository<CustomerNoPassword, Integer> {
    CustomerNoPassword getCustomerByCustomerId (Integer id);

  /*public static final String FIND_PRODUCTS = "SELECT product_id, product_name, description, image_url FROM product";
    @Query(value = FIND_PRODUCTS, nativeQuery = true)
    public List<Object> findProducts();   */

  //  public static final String FIND_customers = "SELECT c from CustomerNoPassword c inner join Password p on c.cutomer_id = p.customer where c.email =:email and p.password =:password";
    public static final String FIND_customers = "SELECT * from Customer c inner join Password p on c.customer_id = p.customer where c.email = :email and p.password = :password";
    @Query(value = FIND_customers, nativeQuery = true)
            public List<CustomerNoPassword> findCustomers (@Param("email") String email, @Param("password") String password);



}

