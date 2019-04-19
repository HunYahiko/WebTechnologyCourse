package com.utm.lab6_api.controller;

import com.utm.lab6_api.exception.ReviewNotFoundException;
import com.utm.lab6_api.model.Review;
import com.utm.lab6_api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    
    private ReviewService reviewService;
    
    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    
    @GetMapping(value = "/reviews")
    public ResponseEntity getAllReviews() throws ReviewNotFoundException {
        List<Review> reviews = reviewService.findAllReviews();
        return ResponseEntity.status(200).body(reviews);
    }
    
    @GetMapping(value = "/reviews/{email}")
    public ResponseEntity getReviewsByEmail(@PathVariable(name = "email") String email) throws ReviewNotFoundException {
        List<Review> reviews = reviewService.findAllReviewsByEmail(email);
        return ResponseEntity.status(200).body(reviews);
    }
    
    @PostMapping(value = "/reviews")
    public ResponseEntity createReview(@RequestBody Review review) {
        return ResponseEntity.status(201).body(reviewService.createReview(review));
    }
    
    @PutMapping(value = "/reviews/{id}")
    public ResponseEntity updateReview(@RequestBody Review review, @PathVariable(name = "id") Long id) throws ReviewNotFoundException {
        reviewService.updateReview(id, review);
        return ResponseEntity.status(204).body("Successfully updated review.");
    }
    
    @DeleteMapping(value = "/reviews/{id}")
    public ResponseEntity deleteReview(@PathVariable(name = "id") Long id) throws ReviewNotFoundException {
        reviewService.deleteReview(id);
        return ResponseEntity.status(204).body("Successfully deleted review.");
    }
}
