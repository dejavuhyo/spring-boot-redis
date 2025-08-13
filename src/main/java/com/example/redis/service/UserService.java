package com.example.redis.service;

import com.example.redis.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String KEY = "user:";

    // Create & Update
    public User save(User user) {
        String key = KEY + user.getId();
        redisTemplate.opsForValue().set(key, user);
        return user;
    }

    // Read (단건 조회)
    public User findById(String id) {
        String key = KEY + id;
        Object userObject = redisTemplate.opsForValue().get(key);
        if (userObject instanceof User) {
            return (User) userObject;
        }
        return null;
    }

    // Read (전체 조회)
    public List<User> findAll() {
        return redisTemplate.keys(KEY + "*").stream()
                .map(key -> (User) redisTemplate.opsForValue().get(key))
                .collect(Collectors.toList());
    }

    // Delete
    public void delete(String id) {
        String key = KEY + id;
        redisTemplate.delete(key);
    }
}
