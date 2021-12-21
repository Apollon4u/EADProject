package com.example.ratingmicroservice.repository;

import com.example.ratingmicroservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findAllByUserId(Long userId);
    List<Rating> findAllByKitchenId(Long kitchenId);
}
