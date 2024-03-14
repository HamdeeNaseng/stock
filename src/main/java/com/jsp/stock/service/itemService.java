package com.jsp.stock.service;

import org.springframework.stereotype.Service;

import com.jsp.stock.entity.Items;
import com.jsp.stock.repository.ItemRepository;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Items addItem(Items item){
        return itemRepository.save(item);
    }

    public Items updateItem(Items item){
        return itemRepository.save(item);
    }

    public void deleteItem(Items item){
        itemRepository.delete(item);
    }

    public Items getItemById(long id){
        return itemRepository.findById(id).get();
    }

    public Iterable<Items> getAllItems(){
        return itemRepository.findAll();
    }
}
