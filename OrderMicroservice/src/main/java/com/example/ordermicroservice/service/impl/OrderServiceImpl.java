package com.example.ordermicroservice.service.impl;

import com.example.ordermicroservice.model.dto.OrderDto;
import com.example.ordermicroservice.model.entity.Order;
import com.example.ordermicroservice.repository.OrderRepository;
import com.example.ordermicroservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderDto.from(order);
    }

    @Override
    public void createOrder(Integer orderNumber) {
        Order order = new Order();
        order.setTotalPrice(orderNumber);
        orderRepository.save(order);
    }
}
