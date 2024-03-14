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
    
    //Get all categories
   
