package com.example.deliverymicroservice.service;

import com.example.deliverymicroservice.model.dto.DeliveryOrderRequestDto;
import com.example.deliverymicroservice.model.entity.DeliveryOrder;
import com.example.deliverymicroservice.repository.DeliveryRepository;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
//    @Autowired
//    private RestTemplate restTemplate;

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

//    @HystrixCommand(
//            fallbackMethod = "getUserByIdFallback",
//            threadPoolKey = "getUserById",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maxQueueSize", value="50"),
//            })
//    public DeliveryOrder getDeliveryOrder(Long id) {
//        return restTemplate.getForObject("http://delivery-service/delivery/get-by-order" + id, DeliveryOrder.class);
//    }

    public DeliveryOrder getDeliveryOrderFallback(Long id) {
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setAddress("Address is not available: Service Unavailable");
        deliveryOrder.setOrderId(0L);
        deliveryOrder.setTrackingNumber("Tracking number is not available: Service Unavailable");
        return deliveryOrder;
    }
}