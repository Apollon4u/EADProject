package com.example.restaurantmanagementmicroservice.controller;

import com.example.restaurantmanagementmicroservice.service.ManageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ManageController {

    public final ManageService manageService;

    @PostMapping("/order-trigger")
    public void triggerMakeOrder(Integer orderNumber) {
        manageService.triggerOrder(orderNumber);
    }
}
