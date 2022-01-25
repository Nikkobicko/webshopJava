package nz.webshop.Servers;


import nz.webshop.models.Product.ProductMini;
import nz.webshop.models.ProductCategory.ProductCategory;
import nz.webshop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductMiniRepository productMiniRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;

public List<ProductMini> getProducts (Integer id) {

    List<ProductCategory> productCategories = productCategoryRepository.findByCategoryId(id);

    List<ProductMini> products = new ArrayList<>();
    Integer productId;
        for(ProductCategory pc :productCategories) {
        productId = pc.getProductId();
        products.add(productMiniRepository.getById(productId));
    }
    return products;
}

}
