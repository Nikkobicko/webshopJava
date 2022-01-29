package nz.webshop.Servers;

import nz.webshop.models.Customer.Customer;
import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.models.Customer.Password;
import nz.webshop.repositories.CustomerRepositoryNoPassword;
import nz.webshop.repositories.PasswordRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepositoryNoPassword customerRepositoryNoPassword;
    @Autowired
    PasswordRepository passwordRepository;



    public CustomerNoPassword getTheOneNoPassword(Customer customer) {
        Customer theOneWithPassword = new Customer();
        CustomerNoPassword theOneNoPassword;// =new CustomerNoPassword();
        List<CustomerNoPassword> customersList = customerRepositoryNoPassword.findCustomers(customer.getEmail(), customer.getPassword());
        if (customersList.size() == 1) { //todo if >1 return error and say that there multiple customers with this password and email
           theOneNoPassword = customersList.get(0);
        }
        else
        { theOneNoPassword = null;
        }
        return theOneNoPassword;
    }

    public void saveNewCustomer(Customer customer) {
        Password passwordEntity = new Password();
        passwordEntity.setPassword(customer.getPassword());

        ModelMapper modelMapper = new ModelMapper();
// user here is a prepopulated User instance
      //  UserDTO userDTO = modelMapper.map(user, UserDTO.class);

    //    modelMapper.getConfiguration().setAmbiguityIgnored(true);
      //  modelMapper.addMappings(clientPropertyMap);







       // CustomerNoPassword customerNoPassword = modelMapper.map(customer, CustomerNoPassword.class);
        CustomerNoPassword customerNoPassword = new CustomerNoPassword();
               modelMapper.map(customer,customerNoPassword );
/*        modelMapper.typeMap(CustomerNoPassword.class,Customer.class).addMappings(mp -> {
            mp.skip(CustomerNoPassword::setPa);
        });*/

    //    customer.setPassword(passwordEntity);
        passwordEntity.setCustomer(customerNoPassword);

        customerRepositoryNoPassword.save(customerNoPassword);
      passwordRepository.save(passwordEntity);
        //customer.setPassword(passwordEntity);

        System.out.println("here");

    }
    PropertyMap<CustomerNoPassword, Customer> clientPropertyMap = new PropertyMap<CustomerNoPassword, Customer>() {
        @Override
        protected void configure() {
            skip(destination.getPassword());
        }
    };

    public Customer getByIdById(Integer id) {
        CustomerNoPassword cnp = customerRepositoryNoPassword.getOne(id);
        String password = cnp.getPasswordEntity().getPassword();
        Customer customer = (Customer) cnp;
        customer.setPassword(password);
        return  customer;
    }
}
