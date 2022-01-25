package nz.webshop.repositories;

import nz.webshop.models.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public static final String FIND_CATEGORIES = "SELECT category_id, category_name FROM category";
    @Query(value = FIND_CATEGORIES, nativeQuery = true)
    public List<Object[]> findCategories();
}
