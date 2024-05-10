package com.perfumery.perfumerywebapp.repositories;

import com.perfumery.perfumerywebapp.models.Cart;
import com.perfumery.perfumerywebapp.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Cart findCartByCartId(Long cartId);
//    Set<Long> findQuantitiesByCartItemIds(Set<Long> productIds);
}
