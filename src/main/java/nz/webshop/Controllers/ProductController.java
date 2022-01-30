package nz.webshop.Controllers;

import nz.webshop.Services.ProductServices;
import nz.webshop.models.Product.Product;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
   private ProductServices productServices;

    @GetMapping(value = "/product")
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product product = productRepository.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping(value = "/productbycategory")
    public List<Product> getProductCategoriesAll() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/productbycategory/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductsByCategoryID(@PathVariable("id") Integer id) {
        List<Product> products = productServices.getProducts(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
