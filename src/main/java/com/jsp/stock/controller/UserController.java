package com.jsp.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.stock.entity.User;
import com.jsp.stock.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-json")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("")
    public String viewBooks(Model model) {
        // Get all users from the database
        List<User> users = userService.getAllUsers();
        // Add the users to the Cache

        model.addAttribute("users", users);
        return "users-view-all";
    }



}    