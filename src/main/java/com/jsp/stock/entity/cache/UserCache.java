package com.jsp.stock.entity.cache;

import org.springframework.data.redis.core.RedisHash;

import com.jsp.stock.entity.User;

import jakarta.persistence.Id;

@RedisHash(value = "User", timeToLive = 300)
public class UserCache {
    @Id
    private Long id;
    
    private User user; // Add this property
    public UserCache() {}
    public UserCache(User user) {
        this.user = user; // Constructor can now access this property
        this.id = user.getId();
    }
    public Long ugetId() {
        return user.getId();
    }
    public String getFirstName() {
        return user.getFirstName();
    }
    public String getEmail() {
        return user.getEmail();
    }
    public String getPassword() {
        return user.getPassword();
    }
    public User getUser() {
        return user;
    }
}