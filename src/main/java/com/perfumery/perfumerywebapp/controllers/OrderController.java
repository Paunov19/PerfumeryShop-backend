package com.perfumery.perfumerywebapp.controllers;

import com.perfumery.perfumerywebapp.dtos.OrderDTO;
import com.perfumery.perfumerywebapp.models.CartItem;
import com.perfumery.perfumerywebapp.models.Order;
import com.perfumery.perfumerywebapp.payload.request.CreateOrderRequest;
import com.perfumery.perfumerywebapp.services.OrderService;
import com.perfumery.perfumerywebapp.utils.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/perfumes")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize(" hasRole('USER')")
    @PostMapping("/checkout/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        orderService.createOrder(createOrderRequest);
        return ResponseEntity.ok("Order successfully placed");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/checkout/orders")
    public ResponseEntity<List<OrderDTO>> getUserOrders() {
        List<Order> userOrders = orderService.getUserOrders();
        List<OrderDTO> userOrdersDTOS = new ArrayList<>();

        for(Order order : userOrders) {
            OrderDTO orderDTO = OrderMapper.convertToOrderDTO(order, order.getUser());

            userOrdersDTOS.add(orderDTO);
        }
        return ResponseEntity.ok(userOrdersDTOS);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/checkout/orders/all")
    public ResponseEntity<List<OrderDTO>> getAllUserOrders() {
        List<Order> allUserOrders = orderService.getAllUserOrders();
        List<OrderDTO> allUserOrdersDTO = new ArrayList<>();

        for(Order order : allUserOrders) {
            OrderDTO orderDTO = OrderMapper.convertToOrderDTO(order, order.getUser());

            allUserOrdersDTO.add(orderDTO);
        }

        return ResponseEntity.ok(allUserOrdersDTO);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long orderId) {
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDTO);
    }
}
