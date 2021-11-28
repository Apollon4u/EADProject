package com.example.ordermicroservice.service;

import com.example.ordermicroservice.model.Order;

public interface OrderService {
    Order getOrder(Long orderId);
    void createOrder(Order dto);
    void addDish(Long orderId, Long dishId);
}
