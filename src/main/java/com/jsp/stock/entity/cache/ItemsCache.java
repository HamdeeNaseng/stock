package com.jsp.stock.entity.cache;

import org.springframework.data.redis.core.RedisHash;

import com.jsp.stock.entity.Items;


@RedisHash(value = "Items", timeToLive = 300)
public class ItemsCache {
   private Long id;
   private Items item;
   
   public ItemsCache(Items item) {
       this.item = item;
       this.id = item.getId();
   }
   public Long getId() {
       return id;
   }

   public Items getItem() {
       return item;
   }
}
