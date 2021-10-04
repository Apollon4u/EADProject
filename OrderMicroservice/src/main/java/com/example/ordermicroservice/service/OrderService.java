package com.example.ordermicroservice.service;

import com.example.ordermicroservice.model.dto.OrderDto;

public interface OrderService {
    OrderDto getOrder(Long orderId);
    void createOrder(OrderDto dto);
    void addDish(Long orderId, Long dishId);
}
