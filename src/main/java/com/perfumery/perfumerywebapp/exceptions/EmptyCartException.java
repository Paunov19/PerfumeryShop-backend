package com.perfumery.perfumerywebapp.exceptions;

public class EmptyCartException extends RuntimeException{

    public EmptyCartException(String message) {
        super(message);
    }
}
