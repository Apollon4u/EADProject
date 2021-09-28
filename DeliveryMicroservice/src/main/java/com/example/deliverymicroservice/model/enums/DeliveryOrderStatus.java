package com.example.deliverymicroservice.model.enums;

import lombok.Getter;

@Getter
public enum DeliveryOrderStatus {

    PENDING,
    PROCESSING,
    CONFIRMED,
    IN_TRANSIT,
    DELIVERED,
    RETURNED,
    LOST,
    CANCELLED

}
