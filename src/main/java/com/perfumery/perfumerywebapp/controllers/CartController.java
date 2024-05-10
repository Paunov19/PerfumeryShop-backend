package com.perfumery.perfumerywebapp.controllers;

import com.perfumery.perfumerywebapp.dtos.CartItemDTO;
import com.perfumery.perfumerywebapp.dtos.PerfumeDTO;
import com.perfumery.perfumerywebapp.exceptions.CartItemNotFoundException;
import com.perfumery.perfumerywebapp.models.Cart;
import com.perfumery.perfumerywebapp.models.CartItem;
import com.perfumery.perfumerywebapp.models.User;
import com.perfumery.perfumerywebapp.payload.request.CartItemUpdateRequest;
import com.perfumery.perfumerywebapp.repositories.CartItemRepository;
import com.perfumery.perfumerywebapp.repositories.UserRepository;
import com.perfumery.perfumerywebapp.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/perfumes")
public class CartController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @PreAuthorize(" hasRole('USER')")
    @PostMapping("/addToCart")
    public ResponseEntity<?> addItemToCart(@RequestBody(required = true) CartItem cartItem) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).get();

        cartService.addToCart(cartItem, user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize(" hasRole('USER')")
    @DeleteMapping("/removeItem/{productId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long productId) {
        cartService.removeItem(productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize(" hasRole('USER')")
    @GetMapping("/checkout")
    public ResponseEntity<?> checkOut() {
        List<CartItemDTO> existingProducts = cartService.findItemsInCart();
        Long totalProductQuantities = cartService.getTotalProductQuantitiesInCart();

        Map<String, Object> response = new HashMap<>();
        response.put("cartItems", existingProducts);
        response.put("totalProductQuantities", totalProductQuantities);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize(" hasRole('USER')")
    @PutMapping("/cart/cartItem/{cartItemId}")
    public ResponseEntity<String> updateCartItem(@PathVariable Long cartItemId, @RequestBody CartItemUpdateRequest newItem) {
        cartService.updateCartItem(cartItemId, newItem);

        Optional<CartItem> updatedItem = cartItemRepository.findById(cartItemId);

        return ResponseEntity.ok("Cart item quantity successfully updated");
    }
}
