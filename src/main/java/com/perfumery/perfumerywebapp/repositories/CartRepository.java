package com.perfumery.perfumerywebapp.repositories;

import com.perfumery.perfumerywebapp.models.Cart;
import com.perfumery.perfumerywebapp.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
