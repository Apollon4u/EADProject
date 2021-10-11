package com.example.deliverymicroservice.service;

import com.example.deliverymicroservice.model.dto.DeliveryOrderRequestDto;
import com.example.deliverymicroservice.model.entity.DeliveryOrder;
import com.example.deliverymicroservice.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryOrder getDeliveryOrderByOrderId(Long orderId) {
        return deliveryRepository.getDeliveryOrderByOrderId(orderId);
    }

    public void createDeliveryOrder(DeliveryOrderRequestDto dto) {
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setOrderId(dto.getOrderId());
        deliveryOrder.setAddress(dto.getAddress());
        deliveryOrder.setTrackingNumber(dto.getTrackingNumber());
        deliveryOrder.setCreatedAt(LocalDateTime.now());
        deliveryRepository.save(deliveryOrder);
    }
}