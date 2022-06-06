package nz.webshop.Controllers;

import nz.webshop.Services.CustomerServices;

import nz.webshop.models.Customer.CustomerDTO;
import nz.webshop.models.Customer.CustomerNoPassword;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CustomerController {
    @Autowired
    CustomerNoPasswordRepository customerNoPasswordRepository;
    @Autowired
    CustomerServices customerServices;

    @GetMapping(value = "/customer")
    public List<CustomerNoPassword> getAll() {
        return customerNoPasswordRepository.findAll();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerNoPassword> getCustomer(@PathVariable("id") Integer id) {
        CustomerNoPassword customer = customerNoPasswordRepository.getById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customerpw/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDTO> getCustomerPw(@PathVariable("id") Integer id) {

        CustomerDTO customerDTO = customerServices.getByIdById(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    public CustomerNoPassword getOne(@RequestBody CustomerDTO customerDTO) {
        CustomerNoPassword theOneNoPassword = customerServices.getTheOneNoPassword(customerDTO);
        return theOneNoPassword; //DTO
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public CustomerDTO addOne(@RequestBody CustomerDTO customerDTO) {
        //customerRepository.save(customer);
        customerServices.saveNewCustomer(customerDTO);
        return customerDTO; //DTO
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public void updateOne(@PathVariable("id") Integer id, @RequestBody CustomerDTO c) {

        CustomerNoPassword c1 = customerNoPasswordRepository.getById(id);

        c1 = new CustomerNoPassword(c.getFirstName(), c.getLastName(), c.getEmail(),
                c.getPhone(), c.getAddress(), c.getPostalCode(), c.getCity());
        c1.setCustomerId(id);
        customerNoPasswordRepository.save(c1);
    }

}
