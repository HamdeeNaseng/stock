package com.jsp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisHash;

import com.jsp.stock.entity.cache.ItemsCache;


@RedisHash(value = "Items", timeToLive = 300)
public interface ItemRedisRepository extends JpaRepository<ItemsCache, Long> {


}
