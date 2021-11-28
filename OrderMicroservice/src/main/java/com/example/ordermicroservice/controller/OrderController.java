package com.example.ordermicroservice.controller;

import com.example.ordermicroservice.model.Order;
import com.example.ordermicroservice.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get-by-id")
    @ApiOperation(value = "Получить заказ по его айди")
    public ResponseEntity<Order> getOrderById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @PostMapping("/make-order")
    @ApiOperation(value = "Создать заказ")
    public void createOrder(@RequestParam("orderNumber") Order dto) {
        orderService.createOrder(dto);
    }

    @PostMapping("/add-dish")
    @ApiOperation(value = "Добавить блюдо в заказ")
    public void addDish(
            @RequestParam("orderId") Long orderId,
            @RequestParam("dishId") Long dishId) {
        orderService.addDish(orderId, dishId);
    }
}
