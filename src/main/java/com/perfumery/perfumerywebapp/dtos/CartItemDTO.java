package com.perfumery.perfumerywebapp.dtos;

import com.perfumery.perfumerywebapp.models.Cart;
import com.perfumery.perfumerywebapp.models.Perfume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemDTO implements Comparable<CartItemDTO> {

    private Long id;
    private String name;
    private double price;
    private String imageUrl;
    private Long quantity;
    private Long productId;
    private Long cartItemId;
    private Date creationDate;

    @Override
    public int compareTo(@NotNull CartItemDTO cartItemDTO) {
         return this.productId.compareTo(cartItemDTO.getProductId());
    }
}
