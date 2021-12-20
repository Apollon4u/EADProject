package com.example.feedbackmicroservice.controller;

import com.example.feedbackmicroservice.model.Feedback;
import com.example.feedbackmicroservice.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feedback")
@Api("Методы работы с отзывами")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    @ApiOperation("Создать отзыв")
    public void createFeedback(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
    }

    @GetMapping
    @ApiOperation("Получить отзывы по айди юзера")
    public void createFeedback(@RequestParam Long id) {
        feedbackService.getAllByUserId(id);
    }
}
