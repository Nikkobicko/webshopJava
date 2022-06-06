package nz.webshop.Services;

import nz.webshop.models.Category.Category;
import nz.webshop.models.FormWrapper;
import nz.webshop.models.Product.Product;
import nz.webshop.models.ProductCategory.ProductCategory;
import nz.webshop.repositories.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServices {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public void setProduct(FormWrapper model) {
        Product product = new Product();
        String imageName = model.getImage();
        String categoryFromDTO = model.getCategory();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(model, product);
        product.setImageURL(imageName);

        List<Category> categoriesByName = categoryRepository.findByNameIgnoreCase(categoryFromDTO);

        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        if (categoriesByName.size() >= 1) {
            category = categoriesByName.get(0);
        } else {
            category.setName(categoryFromDTO);
            categoryRepository.save(category);
        }
        categories.add(category);
        product.setListOfCategories(categories);
        productRepository.save(product);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductId(product.getId());
        productCategory.setCategoryId(category.getId());
        productCategoryRepository.save(productCategory);
    }
}
