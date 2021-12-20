package com.example.feedbackmicroservice.repository;

import com.example.feedbackmicroservice.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByUserId(Long userId);
}
