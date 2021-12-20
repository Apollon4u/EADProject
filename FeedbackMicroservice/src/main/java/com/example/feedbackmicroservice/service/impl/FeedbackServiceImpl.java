package com.example.feedbackmicroservice.service.impl;

import com.example.feedbackmicroservice.model.Feedback;
import com.example.feedbackmicroservice.repository.FeedbackRepository;
import com.example.feedbackmicroservice.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllByUserId(Long userId) {
        return feedbackRepository.findAllByUserId(userId);
    }
}
