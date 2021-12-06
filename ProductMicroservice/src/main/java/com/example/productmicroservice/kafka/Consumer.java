package com.example.productmicroservice.kafka;

import com.example.productmicroservice.model.Order;
import com.example.productmicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ProductService productService;

    @KafkaListener(topics = "order", groupId = "group_id")
    public void consume(Order order) throws IOException {
        System.out.println(String.format("#### -> User " + order.getUserId() + " purchased order " + order.getId()));
    }
}
