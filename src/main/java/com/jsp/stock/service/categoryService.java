package com.jsp.stock.service;

import org.springframework.stereotype.Service;
import com.jsp.stock.repository.CategoryRepository;
import com.jsp.stock.entity.Category;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
    
    //Get all categories
    public Iterable<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
