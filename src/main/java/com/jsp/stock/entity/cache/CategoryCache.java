package com.jsp.stock.entity.cache;

import org.springframework.data.redis.core.RedisHash;

import com.jsp.stock.entity.Category;


@RedisHash(value = "Category", timeToLive = 3000)
public class CategoryCache {
   private Integer id;
   private Category category;
   
   public CategoryCache(Category category) {
       this.category = category;
       this.id = category.getId();
   }
   public Integer getId() {
       return id;
   }

   public Category getCategory() {
       return category;
   }
}
