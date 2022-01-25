package nz.webshop.repositories;

import nz.webshop.models.Product.ProductMini;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMiniRepository extends JpaRepository<ProductMini, Integer> {


}
