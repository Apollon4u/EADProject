package com.example.ratingmicroservice.controller;

import com.example.ratingmicroservice.model.Rating;
import com.example.ratingmicroservice.service.RatingService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
@ApiOperation(value = "Methods for work with rating")
public class RatingController {

    private final RatingService ratingService;

    @PostMapping("/create-rating")
    @ApiOperation(value = "Create new rating")
    public void createRating(@RequestBody Rating rating) {
        ratingService.createRating(rating);
    }

    @GetMapping("/get-by-user")
    @ApiOperation(value = "Get rating by user id")
    public void getRatingByUserId(@RequestParam Long userId) {
        ratingService.getByUserId(userId);
    }

    @GetMapping("/get-by-kitchen")
    @ApiOperation(value = "Get rating by kitchen id")
    public void getRatingByKitchenId(@RequestParam Long kitchenId) {
        ratingService.getByKitchenId(kitchenId);
    }
}
