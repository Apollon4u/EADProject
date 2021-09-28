package com.example.ordermicroservice.service;

import com.example.ordermicroservice.model.dto.OrderDto;

public interface IOrderService {
    OrderDto getOrder(Long orderId);
    void createOrder(Integer orderNumber);
}
