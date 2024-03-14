package com.jsp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.stock.entity.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
    
}
