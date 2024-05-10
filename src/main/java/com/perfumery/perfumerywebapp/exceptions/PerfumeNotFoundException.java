package com.perfumery.perfumerywebapp.exceptions;

public class PerfumeNotFoundException extends RuntimeException{

    public PerfumeNotFoundException(String message) {
        super(message);
    }
}
