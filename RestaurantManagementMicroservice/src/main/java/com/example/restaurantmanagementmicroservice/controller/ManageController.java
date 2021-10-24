package com.example.restaurantmanagementmicroservice.controller;

import com.example.restaurantmanagementmicroservice.service.ManageService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/manager")
public class ManageController {

    public final ManageService manageService;

    @PostMapping("/dish-price")
    @ApiOperation(value = "Get price of a given by id dish")
    public Double getDishPrice(Long id) {
        return manageService.getDishPrice(id);
    }

//    @PostMapping("/order-trigger")
//    public void triggerMakeOrder(Integer orderNumber) {
//        manageService.triggerOrder(orderNumber);
//    }
}
