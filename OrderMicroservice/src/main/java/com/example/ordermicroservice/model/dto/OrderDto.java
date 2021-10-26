package com.example.ordermicroservice.model.dto;

import com.example.ordermicroservice.model.entity.Order;
import com.example.ordermicroservice.model.enums.OrderStatus;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String userId;
    private OrderStatus status;
    private Timestamp dateCreated;
    private Double totalPrice;
    private List<Long> dishIds;

    public static OrderDto from(Order order) {
        return builder()
                .userId(order.getUserId())
                .status(order.getStatus())
                .dateCreated(order.getDateCreated())
                .totalPrice(order.getTotalPrice())
                .dishIds(order.getDishIds())
                .build();
    }
}
