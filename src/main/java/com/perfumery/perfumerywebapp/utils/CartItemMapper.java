package com.perfumery.perfumerywebapp.utils;

import com.perfumery.perfumerywebapp.dtos.CartItemDTO;
import com.perfumery.perfumerywebapp.models.CartItem;
import com.perfumery.perfumerywebapp.models.Perfume;

public class CartItemMapper {

    public CartItemMapper() {
    }

    public static CartItemDTO cartItemToDTO(CartItem cartItem, Perfume perfume) {
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(perfume.getId());
        cartItemDTO.setName(perfume.getName());
        cartItemDTO.setPrice(perfume.getPrice());
        cartItemDTO.setImageUrl(perfume.getImageUrl());
        cartItemDTO.setQuantity(cartItem.getQuantity());
        cartItemDTO.setProductId(perfume.getId());
        cartItemDTO.setCartItemId(cartItem.getId());
        cartItemDTO.setCreationDate(cartItem.getCreationDate());

        return cartItemDTO;
    }
}
