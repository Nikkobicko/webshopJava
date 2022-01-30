package nz.webshop.Services;


import nz.webshop.models.Product.Product;
import nz.webshop.models.ProductCategory.ProductCategory;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

public List<Product> getProducts (Integer id) {

    List<ProductCategory> productCategories = productCategoryRepository.findByCategoryId(id);

    List<Product> products = new ArrayList<>();
    Integer productId;
        for(ProductCategory pc :productCategories) {
        productId = pc.getProductId();
        products.add(productRepository.getById(productId));
    }
    return products;
}
}
