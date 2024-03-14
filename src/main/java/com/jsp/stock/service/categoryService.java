package com.jsp.stock.service;

import com.jsp.stock.entity.Category;
import com.jsp.stock.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  //Get All
  public Iterable<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Category getCategoryById(Integer id) {
    return categoryRepository.findById(id).get();
  }
}
