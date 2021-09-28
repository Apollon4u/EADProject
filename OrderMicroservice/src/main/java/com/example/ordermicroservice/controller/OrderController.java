package com.example.ordermicroservice.controller;

import com.example.ordermicroservice.model.dto.OrderDto;
import com.example.ordermicroservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final IOrderService orderService;

    @GetMapping("/get-by-id")
    public ResponseEntity<OrderDto> getOrderById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @PostMapping("/make-order")
    public void createOrder(@RequestParam("orderNumber") Integer orderNumber) {
        orderService.createOrder(orderNumber);
    }
}
