package com.perfumery.perfumerywebapp.services.impl;

import com.perfumery.perfumerywebapp.exceptions.OrderNotFoundException;
import com.perfumery.perfumerywebapp.exceptions.PerfumeNotFoundException;
import com.perfumery.perfumerywebapp.models.Order;
import com.perfumery.perfumerywebapp.enums.OrderStatusEnum;
import com.perfumery.perfumerywebapp.models.Perfume;
import com.perfumery.perfumerywebapp.repositories.OrderRepository;
import com.perfumery.perfumerywebapp.repositories.PerfumeRepository;
import com.perfumery.perfumerywebapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void updateOrderStatus(Long orderId, OrderStatusEnum newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        order.setStatus(newStatus);

        orderRepository.save(order);
    }

    @Override
    public void changePerfumeAvailability(Long perfumeId) {
        Perfume perfume = perfumeRepository.findById(perfumeId)
                .orElseThrow(() -> new PerfumeNotFoundException("Perfume not found"));

        perfume.setIsAvailable(!perfume.getIsAvailable());

        perfumeRepository.save(perfume);
    }
}
