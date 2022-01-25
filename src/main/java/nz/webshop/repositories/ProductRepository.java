package nz.webshop.repositories;

import nz.webshop.models.Category.Category;
import nz.webshop.models.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    /*public static final String FIND_PRODUCTS = "SELECT product_id, product_name, description, image_url FROM product";
    @Query(value = FIND_PRODUCTS, nativeQuery = true)
    public List<Object> findProducts();
    Product findProductsByListOfCategories(Integer id);
    List<Product> findProductsByListOfCategoriesContaining(Category category);*/

}
