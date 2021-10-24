package com.example.deliverymicroservice.controller;

import com.example.deliverymicroservice.model.dto.DeliveryOrderRequestDto;
import com.example.deliverymicroservice.model.entity.DeliveryOrder;
import com.example.deliverymicroservice.service.DeliveryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/create")
    @ApiOperation(value = "Create delivery order")
    public void createDeliveryOrder(@RequestBody DeliveryOrderRequestDto dto) {
        deliveryService.createDeliveryOrder(dto);
    }

    @GetMapping("/get-by-order")
    @ApiOperation(value = "Get delivery order by order id")
    public ResponseEntity<DeliveryOrder> getDeliveryOrderByOrderId(Long orderId) {
        return ResponseEntity.ok().body(deliveryService.getDeliveryOrderByOrderId(orderId));
    }
}
