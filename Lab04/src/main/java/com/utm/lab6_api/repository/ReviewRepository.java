package com.utm.lab6_api.repository;

import com.utm.lab6_api.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAll();
    List<Review> findAllByEmail(String email);
    Optional<Review> findById(Long id);
}
