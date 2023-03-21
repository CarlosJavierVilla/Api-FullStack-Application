package com.FullStackApplication.Api.apiService.Controllers;

import com.FullStackApplication.Api.domain.Models.Category;
import com.FullStackApplication.Api.domain.Services.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
