package com.example.kitchenmicroservice.service;

import com.example.kitchenmicroservice.model.Dish;

public interface DishService {
    Dish getDish(Long dishId);
    Double getPrice(Long dishId);
    void createDish(Dish dish);
    void addProduct(Long dishId, Long productId);
    String getProductName(Long id);
}
