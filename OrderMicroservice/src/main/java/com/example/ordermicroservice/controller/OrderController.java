package com.example.ordermicroservice.controller;

import com.example.ordermicroservice.model.dto.OrderDto;
import com.example.ordermicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get-by-id")
    public ResponseEntity<OrderDto> getOrderById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @PostMapping("/make-order")
    public void createOrder(@RequestParam("orderNumber") OrderDto dto) {
        orderService.createOrder(dto);
    }

    @PostMapping("/add-dish")
    public void addDish(
            @RequestParam("orderId") Long orderId,
            @RequestParam("dishId") Long dishId) {
        orderService.addDish(orderId, dishId);
    }
}
