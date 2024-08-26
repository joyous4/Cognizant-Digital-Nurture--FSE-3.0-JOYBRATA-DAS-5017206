package com.example.bookstoreapi.handler;


//Defined the global exception
public class InvalidInputException extends RuntimeException {
    
    public InvalidInputException(String message) {
        super(message);
    }
}