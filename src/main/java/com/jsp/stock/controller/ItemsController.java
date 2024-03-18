package com.jsp.stock.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.stock.entity.Items;
import com.jsp.stock.service.CategoryService;
import com.jsp.stock.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemsController {

    private final ItemService itemService;
    private final CategoryService categoryService;
    public ItemsController(ItemService itemService, CategoryService categoryService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
    }
    
    @GetMapping("/all-json")
    public ResponseEntity<Iterable<Items>> getAllItems() {
        Iterable<Items> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/view-all")
    public String viewBooks(Model model) {
        // Get all users from the database
        Iterable<Items> items = itemService.getAllItems();
        // Add the users to the Cache

        model.addAttribute("items", items);
        return "items-view-all";
    }

    @GetMapping("/add")
    public String addItemView(Model model) {
        model.addAttribute("item", new Items());
        model.addAttribute("addItemSuccess", false);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "item-add";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") Items item, Model model, @RequestParam("image") MultipartFile file) throws IOException {
        // Add logic to save the Item to the database using your ItemService
        if(file.isEmpty() || file.getSize() == 0 || file.getOriginalFilename().isEmpty() || file.getOriginalFilename().equals("")) {
            model.addAttribute("message", "Error: File image is empty");
            return "item-add";
        }
        if (item == null ) {
            model.addAttribute("message", "Error: Item is null");
            return "item-add";
        }
            
        boolean result = itemService.saveItemWithImage(item, file);

        // Set attributes for the success message in the JSP
        model.addAttribute("addItemSuccess", result);
        model.addAttribute("savedItem", item);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "item-add"; // This should be the name of your JSP file
    }

    @GetMapping("/update")
    public String editItem(@RequestParam Long id, Model model) {
    
        Items item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-update";

    }    
    @PostMapping("/update")
    public String updateItem(@ModelAttribute("item") Items updatedItem, Model model) {
        // Perform the update logic using the updatedItem object
        // You can use the ItemService to update the Item in the database

         itemService.updatedItem(updatedItem);
         model.addAttribute("UpadteItemSuccess", true);
         model.addAttribute("updatedItem", updatedItem);
        return "redirect:/item/update?id=" + updatedItem.getId(); // Redirect to the view Items page after updating
    }

}
