package com.utm.lab6_api.exception;

public class ReviewNotFoundException extends Exception {
    
    public ReviewNotFoundException() {
        super("Review Not Found");
    }
    
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
