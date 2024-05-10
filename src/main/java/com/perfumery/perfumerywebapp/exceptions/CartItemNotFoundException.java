package com.perfumery.perfumerywebapp.exceptions;

import com.perfumery.perfumerywebapp.models.Cart;

public class CartItemNotFoundException extends RuntimeException{

    public CartItemNotFoundException(String message) {
        super(message);
    }
}
