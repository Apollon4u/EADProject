package com.example.deliverymicroservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderRequestDto {
    private Long orderId;
    private String trackingNumber;
    private String address;
}
