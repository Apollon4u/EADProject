package com.example.ratingmicroservice.service;

import com.example.ratingmicroservice.model.Rating;

import java.util.List;

public interface RatingService {
    void createRating(Rating rating);
    List<Rating> getByUserId(Long id);
    List<Rating> getByKitchenId(Long id);
}
