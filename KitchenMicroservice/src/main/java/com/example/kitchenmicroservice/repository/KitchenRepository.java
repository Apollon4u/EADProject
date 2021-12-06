package com.example.kitchenmicroservice.repository;

import com.example.kitchenmicroservice.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
    Kitchen getById(Long kitchenId);
}
