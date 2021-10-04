package com.example.kitchenmicroservice.service.impl;

import com.example.kitchenmicroservice.model.Dish;
import com.example.kitchenmicroservice.repository.DishRepository;
import com.example.kitchenmicroservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    @Override
    public Dish getDish(Long dishId) {
        return dishRepository.getById(dishId);
    }

    @Override
    public Double getPrice(Long dishId) {
        return getDish(dishId).getPrice();
    }

    @Override
    public void createDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void addProduct(Long dishId, Long productId) {
        dishRepository.getById(dishId).getProductIds().add(productId);
    }
}
