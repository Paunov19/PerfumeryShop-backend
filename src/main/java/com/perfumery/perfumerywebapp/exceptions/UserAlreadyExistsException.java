package com.perfumery.perfumerywebapp.exceptions;

public class UserAlreadyExistsException  extends RuntimeException{

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
