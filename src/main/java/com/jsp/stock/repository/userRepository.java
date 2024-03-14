package com.jsp.stock.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.stock.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    
} 