package com.perfumery.perfumerywebapp.models;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CartItem implements Comparable<CartItem> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    @ManyToOne
    private Cart cart;

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Perfume productId;
    private Long productId;

    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartItem() {
    }

    public CartItem(Long id, Long quantity, Cart cart, Long productId, Date creationDate) {
        this.id = id;
        this.quantity = quantity;
        this.cart = cart;
        this.productId = productId;
        this.creationDate = creationDate;
    }

    public Cart getCart() {
        if(cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public int compareTo(@NotNull CartItem o) {
        return this.productId.compareTo(o.getProductId());
    }

//    @Override
//    public String toString() {
//        return "CartItem{" +
//                "id=" + id +
//                ", quantity=" + quantity +
//                ", cart=" + cart +
//                '}';
//    }
}
