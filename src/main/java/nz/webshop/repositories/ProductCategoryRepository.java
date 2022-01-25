package nz.webshop.repositories;

import nz.webshop.models.ProductCategory.ProductCategory;
import nz.webshop.models.ProductCategory.ProductCategoryID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryID>{
    List<ProductCategory> findByCategoryId (Integer id);

}
