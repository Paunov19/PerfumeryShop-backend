package com.perfumery.perfumerywebapp.payload.request;

import com.perfumery.perfumerywebapp.enums.OrderStatusEnum;

public class UpdateOrderStatusRequest {
    private Long orderId;
    private OrderStatusEnum newStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(OrderStatusEnum newStatus) {
        this.newStatus = newStatus;
    }
}
