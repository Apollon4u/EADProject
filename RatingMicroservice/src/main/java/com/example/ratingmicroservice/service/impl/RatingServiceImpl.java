package com.example.ratingmicroservice.service.impl;

import com.example.ratingmicroservice.model.Rating;
import com.example.ratingmicroservice.repository.RatingRepository;
import com.example.ratingmicroservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public void createRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getByUserId(Long id) {
        return ratingRepository.findAllByUserId(id);
    }

    @Override
    public List<Rating> getByKitchenId(Long id) {
        return ratingRepository.findAllByKitchenId(id);
    }
}
