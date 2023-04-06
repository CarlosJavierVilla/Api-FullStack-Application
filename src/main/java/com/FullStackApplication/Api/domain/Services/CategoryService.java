package com.FullStackApplication.Api.domain.Services;

import com.FullStackApplication.Api.domain.Models.Category;
import com.FullStackApplication.Api.domain.Models.Sneaker;
import com.FullStackApplication.Api.infrastructure.Repositories.ICategoryRepository;

import java.util.List;

public class CategoryService {
    private final ICategoryRepository categoryRepository;
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAllCategories(){
        return this.categoryRepository.findAll();
    }
    public Category findCategoryById(Long id){
        var categoryOptional = this.categoryRepository.findById(id);
        if(categoryOptional.isEmpty()) throw new RuntimeException("The category with id: " + id + " doesn't exist in our Data Base. Please try again with other id.");
        return categoryOptional.get();
    }

}
