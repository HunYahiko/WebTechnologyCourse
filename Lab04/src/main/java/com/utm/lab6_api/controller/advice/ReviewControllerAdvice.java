package com.utm.lab6_api.controller.advice;

import com.utm.lab6_api.exception.ReviewNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReviewControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ReviewNotFoundException.class})
    protected ResponseEntity reviewNotFoundHandler(ReviewNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}
