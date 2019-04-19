package com.utm.lab6_api.service.impl;

import com.utm.lab6_api.exception.ReviewNotFoundException;
import com.utm.lab6_api.model.Review;
import com.utm.lab6_api.repository.ReviewRepository;
import com.utm.lab6_api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ReviewServiceImpl implements ReviewService {
    
    private ReviewRepository reviewRepository;
    private Supplier<ReviewNotFoundException> exceptionSupplier = ReviewNotFoundException::new;
    
    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    
    @Override
    public List<Review> findAllReviews() throws ReviewNotFoundException {
        List<Review> reviews = reviewRepository.findAll();
        if (reviews.isEmpty()) {
            throw exceptionSupplier.get();
        }
        return reviews;
    }
    
    @Override
    public List<Review> findAllReviewsByEmail(String email) throws ReviewNotFoundException {
        List<Review> reviews = reviewRepository.findAllByEmail(email);
        if (reviews.isEmpty()) {
            throw exceptionSupplier.get();
        }
        return reviews;
    }
    
    @Override
    public Review findReviewById(Long id) throws ReviewNotFoundException {
        return reviewRepository.findById(id).orElseThrow(exceptionSupplier);
    }
    
    @Override
    public Review createReview(Review review) {
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    
    @Override
    public Review updateReview(Long id, Review review) throws ReviewNotFoundException {
        Review oldReview = reviewRepository.findById(id).orElseThrow(exceptionSupplier);
        oldReview.setReviewText(review.getReviewText());
        return reviewRepository.save(oldReview);
    }
    
    @Override
    public void deleteReview(Long id) throws ReviewNotFoundException {
        Review review = reviewRepository.findById(id).orElseThrow(exceptionSupplier);
        reviewRepository.delete(review);
    }
}
