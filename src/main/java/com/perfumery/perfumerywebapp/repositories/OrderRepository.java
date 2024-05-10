package com.perfumery.perfumerywebapp.repositories;

import com.perfumery.perfumerywebapp.models.Order;
import com.perfumery.perfumerywebapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
