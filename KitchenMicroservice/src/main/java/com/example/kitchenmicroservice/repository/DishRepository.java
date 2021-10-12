package com.example.kitchenmicroservice.repository;

import com.example.kitchenmicroservice.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findDishById(Long id);
}
