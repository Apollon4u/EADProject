package com.example.usermicroservice.service;

import com.example.usermicroservice.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long userId);
    void createUser(User user);
    List<User> getUsers();
}
