package com.example.ordermicroservice.model.dto;

import com.example.ordermicroservice.model.entity.Order;
import com.example.ordermicroservice.model.enums.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class OrderDto {

    private Long id;
    private OrderStatus status;
    private Timestamp dateCreated;
    private Double totalPrice;

    public static OrderDto from(Order order) {
        return builder()
                .id(order.getId())
                .status(order.getStatus())
                .dateCreated(order.getDateCreated())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
