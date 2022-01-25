package nz.webshop.Servers;

import nz.webshop.models.Customer.Customer;
import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.repositories.CustomerRepository;
import nz.webshop.repositories.CustomerRepositoryNoPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerRepositoryNoPassword customerRepositoryNoPassword;


    public CustomerNoPassword getTheOneNoPassword(Customer customer) {
        Customer theOneWithPassword = new Customer();
        CustomerNoPassword theOneNoPassword;// =new CustomerNoPassword();
        List<Customer> customersList = customerRepository.
                findCustomerByEmailAndPassword(customer.getEmail(), customer.getPassword());
        if (customersList.size() >= 1) {
            theOneNoPassword = null;
            for (Customer cc : customersList) {
                if (cc.getPassword().equals(customer.getPassword())) {
                    System.out.println("fName: " + cc.getFirstName());
                    theOneWithPassword = cc;
                    theOneNoPassword = customerRepositoryNoPassword.getById(theOneWithPassword.getCustomerId());
                }
            }
        } else theOneNoPassword = null;
        return theOneNoPassword;
    }
}
