package com.jsp.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.stock.entity.User;
import com.jsp.stock.repository.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void save(User user) {
        userRepository.save(user);
    }
    public User getUserById(Long authorId) {
        return userRepository.findById(authorId).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
