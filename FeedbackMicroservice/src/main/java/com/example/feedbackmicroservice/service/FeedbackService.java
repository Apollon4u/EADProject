package com.example.feedbackmicroservice.service;

import com.example.feedbackmicroservice.model.Feedback;

import java.util.List;

public interface FeedbackService {
    void save(Feedback feedback);
    List<Feedback> getAllByUserId(Long userId);
}
