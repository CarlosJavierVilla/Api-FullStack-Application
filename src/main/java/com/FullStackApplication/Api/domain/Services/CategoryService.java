package com.FullStackApplication.Api.domain.Services;

import com.FullStackApplication.Api.domain.Models.Category;
import com.FullStackApplication.Api.infrastructure.Repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }
}
