package com.perfumery.perfumerywebapp.services;

import com.perfumery.perfumerywebapp.dtos.OrderDTO;
import com.perfumery.perfumerywebapp.models.CartItem;
import com.perfumery.perfumerywebapp.models.Order;
import com.perfumery.perfumerywebapp.payload.request.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder(CreateOrderRequest createOrderRequest);
    List<Order> getUserOrders();
    OrderDTO getOrderById(Long orderId);
    List<Order> getAllUserOrders();
}
