package com.example.ordermicroservice.service.impl;

import com.example.ordermicroservice.converter.OrderConverter;
import com.example.ordermicroservice.model.dto.OrderDto;
import com.example.ordermicroservice.model.entity.Order;
import com.example.ordermicroservice.repository.OrderRepository;
import com.example.ordermicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Override
    public OrderDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderDto.from(order);
    }

    @Override
    public void createOrder(OrderDto dto) {
        orderRepository.save(orderConverter.convert(dto));
    }

    @Override
    public void addDish(Long orderId, Long dishId) {
        orderRepository.getById(orderId).getDishIds().add(dishId);
    }
}
