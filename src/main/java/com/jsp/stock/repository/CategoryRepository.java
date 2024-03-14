package com.jsp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.stock.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
