package com.example.blog.repository;

import com.example.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByName(String name);
    public User findByOpenid(String openId);
}
