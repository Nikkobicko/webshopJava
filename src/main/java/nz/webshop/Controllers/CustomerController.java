package nz.webshop.Controllers;

import nz.webshop.Servers.CustomerServices;

import nz.webshop.models.Customer.Customer;
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
    CustomerRepositoryNoPassword customerRepositoryNoPassword;
    @Autowired
    CustomerServices customerServices;

    @GetMapping(value = "/customertest")
    //public List<CustomerNoPassword> getAll() {return customerRepositoryNoPassword.findAll();}
    public String getAllTest() {return "working";}

    @GetMapping(value = "/customer")
    public List<CustomerNoPassword> getAll() {return customerRepositoryNoPassword.findAll();}

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerNoPassword> getCustomer(@PathVariable("id") Integer id) {
        CustomerNoPassword customer = customerRepositoryNoPassword.getById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @RequestMapping(value = "/customerpw/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerPw(@PathVariable("id") Integer id) {

        Customer customer = customerServices.getByIdById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    public CustomerNoPassword getOne(@RequestBody Customer customer) {
        CustomerNoPassword theOneNoPassword=customerServices.getTheOneNoPassword(customer);
        return theOneNoPassword;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer addOne(@RequestBody Customer customer) {
        //customerRepository.save(customer);
        customerServices.saveNewCustomer (customer);
        return customer;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public CustomerNoPassword updateOne(@PathVariable("id") Integer id, @RequestBody Customer c) {
        CustomerNoPassword c1 = customerRepositoryNoPassword.getById(id);

        c1= new CustomerNoPassword(c.getFirstName(), c.getLastName(), c.getEmail(),
                c.getPhone(), c.getAddress(), c.getPostalCode(), c.getCity());
        c1.setCustomerId(id);
        customerRepositoryNoPassword.save(c1);
        return c1;
    }


   /* @GetMapping(value = "/customerjdbc")
    public String getAllJDBC() {
        ResultSet rs = null;
        Statement stm = null;
        String result="";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://testfree.czzj8lfy5a3f.eu-central-1.rds.amazonaws.com/webshop","xxx", "xxx");)
        {
            stm = con.createStatement();
            String query="SELECT product_name as produkter FROM product";

            rs = stm.executeQuery(query);

            System.out.println("Question 1 result:");

            ArrayList<String> rowArray= new ArrayList<>();
            while (rs.next()) {
                result=result + " "+ rs.getString(1);
                }
                System.out.println("result: "+result);
            } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null)
                    rs.close();
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }*/


}
