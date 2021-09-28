package com.example.restaurantmanagementmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ManageService {

    public void triggerOrder(Integer orderNumber) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(
                "http://localhost:8082/orders/make-order",
                orderNumber,
                Integer.class);
    }
}
