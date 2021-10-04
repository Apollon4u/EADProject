package com.example.usermicroservice.service;

import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.dto.UserRegDto;

import java.util.List;

public interface UserService {
    UserDto getUser(Long userId);
    void createUser(UserRegDto dto);
    void makeOrder(Long userId, List<Long> dishIds);
}
