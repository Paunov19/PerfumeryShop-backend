package com.perfumery.perfumerywebapp.services;

import com.perfumery.perfumerywebapp.dtos.CartItemDTO;
import com.perfumery.perfumerywebapp.dtos.PerfumeDTO;
import com.perfumery.perfumerywebapp.models.Cart;
import com.perfumery.perfumerywebapp.models.CartItem;
import com.perfumery.perfumerywebapp.models.User;
import com.perfumery.perfumerywebapp.payload.request.CartItemUpdateRequest;

import java.util.List;

public interface CartService {
    void addToCart(CartItem cartItem, User user);

    void removeItem(Long cartItemId);

    void updateCartItem(Long cartItemId, CartItemUpdateRequest cartItem);

    List<PerfumeDTO> findAllByProductId();

   List<CartItemDTO> findItemsInCart();

   Long getTotalProductQuantitiesInCart();

}
