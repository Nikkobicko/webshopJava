package nz.webshop.Controllers;

import nz.webshop.Servers.ProductServices;
import nz.webshop.models.Category.CategoryMini;
import nz.webshop.models.Product.ProductMini;
import nz.webshop.models.ProductCategory.ProductCategory;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    ProductMiniRepository productMiniRepository;
    @Autowired
   private ProductServices productServices;

    @GetMapping(value = "/product")
    public List<ProductMini> getAll() {
        return productMiniRepository.findAll();
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductMini> getProduct(@PathVariable("id") Integer id) {
        ProductMini product = productMiniRepository.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping(value = "/productbycategory")
    public List<ProductMini> getProductCategoriesAll() {
        return productMiniRepository.findAll();
    }

    @RequestMapping(value = "/productbycategory/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductMini>> getProductsByCategoryID(@PathVariable("id") Integer id) {
        List<ProductMini> products = productServices.getProducts(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
