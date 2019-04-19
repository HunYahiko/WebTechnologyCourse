package com.utm.lab6_api.service;

import com.utm.lab6_api.exception.ReviewNotFoundException;
import com.utm.lab6_api.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAllReviews() throws ReviewNotFoundException;
    List<Review> findAllReviewsByEmail(String email) throws ReviewNotFoundException;
    Review findReviewById(Long id) throws ReviewNotFoundException;
    Review createReview(Review review);
    Review updateReview(Long id, Review review) throws ReviewNotFoundException;
    void deleteReview(Long id) throws ReviewNotFoundException;
}
