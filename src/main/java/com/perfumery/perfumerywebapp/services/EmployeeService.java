package com.perfumery.perfumerywebapp.services;

import com.perfumery.perfumerywebapp.enums.OrderStatusEnum;

public interface EmployeeService {
    void updateOrderStatus(Long orderId, OrderStatusEnum newStatus);
    void changePerfumeAvailability(Long perfumeId);
}
