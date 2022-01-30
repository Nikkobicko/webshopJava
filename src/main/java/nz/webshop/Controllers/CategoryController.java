package nz.webshop.Controllers;

import nz.webshop.models.Category.Category;
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



    @GetMapping(value = "")
    public List<Category> getAll() {  return categoryRepository.findAll();  }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id) {
        Category category = categoryRepository.getById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    }