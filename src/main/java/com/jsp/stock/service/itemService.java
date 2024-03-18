package com.jsp.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.stock.entity.Items;
import com.jsp.stock.repository.ItemRepository;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    public void save(Items item) {
        itemRepository.save(item);
    }

    public Items getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Iterable<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
    public boolean saveItemWithImage(Items item, MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveItemWithImage'");
    }
    public void updatedItem(Items updatedItem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatedItem'");
    }

    
}
