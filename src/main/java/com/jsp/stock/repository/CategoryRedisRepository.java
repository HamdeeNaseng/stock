package com.jsp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisHash;

import com.jsp.stock.entity.cache.CategoryCache;

@RedisHash(value = "Category", timeToLive = 3000)
public interface CategoryRedisRepository extends JpaRepository<CategoryCache, Integer> {


}
