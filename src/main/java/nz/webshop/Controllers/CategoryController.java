package nz.webshop.Controllers;

import nz.webshop.models.Category.CategoryMini;
import nz.webshop.repositories.CategoryMiniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nz.webshop.repositories.CategoryRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMiniRepository categoryMiniRepository;

    @GetMapping(value = "")
    public List<CategoryMini> getAll() {  return categoryMiniRepository.findAll();  }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryMini> getCategory(@PathVariable("id") Integer id) {
        CategoryMini category = categoryMiniRepository.getById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    }