package com.jsp.stock.service;

import java.util.UUID;

import com.jsp.stock.entity.User;
import com.jsp.stock.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void save(User user) {
        userRepository.save(user);
    }
    public User getUserById(UUID authorId) {
        return userRepository.findById(authorId).orElse(null);
    }

}
