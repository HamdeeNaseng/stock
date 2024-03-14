package com.jsp.stock.controller;

import com.jsp.stock.service.CategoryService;
import com.jsp.stock.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {

  private final ItemService itemService;
  private final CategoryService categoryService;
  public ItemController(ItemService itemService, CategoryService categoryService) {
    this.itemService = itemService;
    this.categoryService = categoryService;
  }
  
}
