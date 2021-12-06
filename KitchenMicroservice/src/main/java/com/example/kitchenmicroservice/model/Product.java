package com.example.kitchenmicroservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private Long kitchenId;
    private boolean active;
    private Double totalPrice;
}
