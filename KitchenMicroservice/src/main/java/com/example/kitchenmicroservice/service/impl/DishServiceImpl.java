package com.example.kitchenmicroservice.service.impl;

import com.example.kitchenmicroservice.model.Dish;
import com.example.kitchenmicroservice.repository.DishRepository;
import com.example.kitchenmicroservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Dish dish = dishRepository.findDishById(dishId);
        List<Long> ids = dish.getProductIds();
        ids.add(productId);
        dish.setProductIds(ids);
        dishRepository.save(dish);
    }
}
