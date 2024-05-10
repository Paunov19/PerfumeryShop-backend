package com.perfumery.perfumerywebapp.dtos;

import java.util.Date;

public class OrderDTO {
     private Long id;
     private String deliveryAddress;
     private String customerTelephone;
     private Date orderDate;
     private String status;
     private double totalPrice;
   // private List<CartItemDTO> cartItems;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

//    public List<com.perfumery.perfumerywebapp.dtos.CartItemDTO> getCartItems() {
//        return cartItems;
//    }
//
//    public void setCartItems(List<com.perfumery.perfumerywebapp.dtos.CartItemDTO> cartItems) {
//        this.cartItems = cartItems;
//    }
}
