package com.example.mapper;

import com.example.entity.User;

import java.util.List;

public interface UserMapper {
    public User queryUserByName(String userName);
    List<User> selectAll();
}
