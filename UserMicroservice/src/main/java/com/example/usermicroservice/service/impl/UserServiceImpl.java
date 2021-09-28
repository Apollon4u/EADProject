package com.example.usermicroservice.service.impl;

import com.example.usermicroservice.model.dto.UserDto;
import com.example.usermicroservice.model.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.example.usermicroservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDto.from(user);
    }

    @Override
    public void makeOrder(Integer orderNumber) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                "http://localhost:8081/restaurant_management/order-trigger",
                orderNumber,
                Integer.class);
    }
}
