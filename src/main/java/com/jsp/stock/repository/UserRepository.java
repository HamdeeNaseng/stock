package com.jsp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.stock.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
