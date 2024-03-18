package com.jsp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisHash;

import com.jsp.stock.entity.cache.UserCache;

import java.util.UUID;

@RedisHash(value = "User", timeToLive = 300)
public interface UserRedisRepository extends JpaRepository<UserCache, Long> {


}
