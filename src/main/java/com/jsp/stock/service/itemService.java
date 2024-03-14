package com.jsp.stock.service;

import org.springframework.stereotype.Service;

import com.jsp.stock.repository.ItemRepository;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    
}
