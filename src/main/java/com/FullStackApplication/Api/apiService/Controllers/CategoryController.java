package com.FullStackApplication.Api.apiService.Controllers;

import com.FullStackApplication.Api.domain.Models.Category;
import com.FullStackApplication.Api.domain.Models.Sneaker;
import com.FullStackApplication.Api.domain.Services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/sneakers")

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> findAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.findCategoryById(id));
    }
}
