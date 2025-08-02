package com.example.demo.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String s, String username) {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
