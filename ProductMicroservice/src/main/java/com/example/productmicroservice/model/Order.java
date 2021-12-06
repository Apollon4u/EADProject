package com.example.productmicroservice.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Order {
    private Long id;
    private String userId;
    private Timestamp dateCreated;
    private Double totalPrice;
}
