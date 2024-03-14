package com.jsp.stock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.stock.entity.Items;
import com.jsp.stock.service.ItemService;
import com.jsp.stock.service.CategoryService;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;
    public ItemController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
    }
    
    @GetMapping("/all-json")
    public ResponseEntity<Iterable<Items>> getAllItems() {
        Iterable<Items> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
}
