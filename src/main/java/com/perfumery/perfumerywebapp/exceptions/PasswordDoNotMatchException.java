package com.perfumery.perfumerywebapp.exceptions;

public class PasswordDoNotMatchException extends RuntimeException{

    public PasswordDoNotMatchException(String message) {
        super(message);
    }
}
