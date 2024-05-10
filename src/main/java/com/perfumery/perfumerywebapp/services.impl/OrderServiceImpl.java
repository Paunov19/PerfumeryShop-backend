package com.perfumery.perfumerywebapp.services.impl;

import com.perfumery.perfumerywebapp.dtos.OrderDTO;
import com.perfumery.perfumerywebapp.enums.OrderStatusEnum;
import com.perfumery.perfumerywebapp.exceptions.InvalidOrderException;
import com.perfumery.perfumerywebapp.exceptions.OrderNotFoundException;
import com.perfumery.perfumerywebapp.exceptions.PerfumeNotFoundException;
import com.perfumery.perfumerywebapp.exceptions.UnauthorizedException;
import com.perfumery.perfumerywebapp.models.*;
import com.perfumery.perfumerywebapp.payload.request.CreateOrderRequest;
import com.perfumery.perfumerywebapp.repositories.*;
import com.perfumery.perfumerywebapp.services.OrderService;
import com.perfumery.perfumerywebapp.utils.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfumeRepository perfumeRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Order createOrder(CreateOrderRequest createOrderRequest) {
        User currentLoggedUser = getCurrentLoggedUser();

        Cart cart = currentLoggedUser.getCart();
        List<CartItem> existingCartItems = new ArrayList<>(cart.getCartItems());

        if (existingCartItems.isEmpty()) {
            throw new InvalidOrderException("Cannot create order with an empty cart.");
        }

        Order order = new Order();
        order.setUser(currentLoggedUser);
        order.setDeliveryAddress(createOrderRequest.getDeliveryAddress());
        order.setCustomerTelephone(createOrderRequest.getCustomerTelephone());
        order.setStatus(OrderStatusEnum.PENDING);
        order.setOrderDate(new Date());

        double totalPrice = calculateTotalPrice(existingCartItems);
        order.setTotalPrice(totalPrice);

        Order savedOrder = orderRepository.save(order);

        List<CartItem> newCartItems = new ArrayList<>();
        for (CartItem cartItem : existingCartItems) {
            CartItem newCartItem = new CartItem();
            newCartItem.setProductId(cartItem.getProductId());
            newCartItem.setQuantity(cartItem.getQuantity());
            newCartItem.setCreationDate(new Date());
            newCartItem.setCart(cart);
            newCartItem.setOrder(savedOrder);
            newCartItems.add(newCartItem);
        }

        cartItemRepository.deleteAll(existingCartItems);

        cart.setCartItems(newCartItems);
        cart.getCartItems().clear();
        cartRepository.save(cart);

        return savedOrder;
    }
    private User getCurrentLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<Order> getUserOrders() {
        User currentlyLoggedUser = getCurrentLoggedUser();

        return orderRepository.findByUser(currentlyLoggedUser);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        return OrderMapper.convertToOrderDTO(order, getCurrentLoggedUser());
    }

    @Override
    public List<Order> getAllUserOrders() {
        User currentlyLoggedUser = getCurrentLoggedUser();

        Set<Role> roles = currentlyLoggedUser.getRoles();

        boolean isEmployee = roles.stream()
                .anyMatch(auth -> auth.getName().name().equals("ROLE_EMPLOYEE"));

        if (!isEmployee) {
            throw new UnauthorizedException("Access denied. User is not an employee.");
        }

        return orderRepository.findAll();
    }

    private double calculateTotalPrice(List<CartItem> cartItems) {
        double totalPrice = 0;

        for(CartItem cartItem : cartItems) {
           Perfume perfume = perfumeRepository.findById(cartItem.getProductId())
                   .orElseThrow(() -> new PerfumeNotFoundException("Perfume not found"));

           double totalItemPrice = perfume.getPrice() * cartItem.getQuantity();
           totalPrice += totalItemPrice;
        }

        return totalPrice;
    }
}
