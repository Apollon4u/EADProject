package com.example.usermicroservice.service;

import com.example.usermicroservice.model.dto.UserDto;

public interface IUserService {
    UserDto getUser(Long userId);
    void makeOrder(Integer orderNumber);
}
