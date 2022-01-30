package nz.webshop.Services;

import nz.webshop.models.Customer.CustomerDTO;
import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.models.Customer.Password;
import nz.webshop.repositories.CustomerNoPasswordRepository;
import nz.webshop.repositories.PasswordRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    CustomerNoPasswordRepository customerNoPasswordRepository;
    @Autowired
    PasswordRepository passwordRepository;


    public CustomerNoPassword getTheOneNoPassword(CustomerDTO customerDTO) {
        CustomerDTO theOneWithPassword = new CustomerDTO();
        CustomerNoPassword theOneNoPassword;// =new CustomerNoPassword();
        List<CustomerNoPassword> customersList = customerNoPasswordRepository.findCustomers(customerDTO.getEmail(), customerDTO.getPassword());
        if (customersList.size() == 1) { //todo if >1 return error and say that there multiple customers with this password and email
            theOneNoPassword = customersList.get(0);
        } else {
            theOneNoPassword = null;
        }
        return theOneNoPassword;
    }

    public void saveNewCustomer(CustomerDTO customerDTO) {
        Password passwordEntity = new Password();
        passwordEntity.setPassword(customerDTO.getPassword());
        ModelMapper modelMapper = new ModelMapper();
        CustomerNoPassword customerNoPassword = new CustomerNoPassword();
        modelMapper.map(customerDTO, customerNoPassword);

        passwordEntity.setCustomer(customerNoPassword);

        customerNoPasswordRepository.save(customerNoPassword);
        passwordRepository.save(passwordEntity);

    }

    PropertyMap<CustomerNoPassword, CustomerDTO> clientPropertyMap = new PropertyMap<CustomerNoPassword, CustomerDTO>() {
        @Override
        protected void configure() {
            skip(destination.getPassword());
        }
    };

    public CustomerDTO getByIdById(Integer id) {
        CustomerNoPassword cnp = customerNoPasswordRepository.getById(id);
        String password = cnp.getPasswordEntity().getPassword();

        CustomerDTO customerDTO = new CustomerDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(cnp, customerDTO);

        customerDTO.setPassword(password);
        return customerDTO;
    }
}
