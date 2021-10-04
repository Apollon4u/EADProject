package com.example.usermicroservice.service.impl;

import com.example.usermicroservice.converter.UserRegConverter;
import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.dto.UserRegDto;
import com.example.usermicroservice.model.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.example.usermicroservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRegConverter userRegConverter;

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.from(user);
    }

    @Override
    public void createUser(UserRegDto dto) {
        userRepository.save(userRegConverter.convert(dto));
    }

    @Override
    public void makeOrder(Long userId, List<Long> dishIds) {

    }
}
