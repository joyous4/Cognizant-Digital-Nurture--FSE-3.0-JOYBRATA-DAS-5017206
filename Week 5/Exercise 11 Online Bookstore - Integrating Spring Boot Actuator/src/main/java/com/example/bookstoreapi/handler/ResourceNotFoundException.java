package com.example.bookstoreapi.handler;



//defined the global exception
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
