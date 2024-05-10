package com.perfumery.perfumerywebapp.models;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "perfumes")
public class Perfume implements Comparable<Perfume> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    //@Column(name = "Номер")
    private Long id;
    //@Column(name = "Име")
    @NotBlank
    private String name;
    //@Column(name = "Големина")
//    @NotBlank
//    private String size;
    //@Column(name = "Цена")
    @NotBlank
    private Double price;
    @NotBlank
    private String imageUrl;
    //@Column(name = "Продукти")
    @NotBlank
    private String products;

    @NotBlank
    private Long quantity;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    //@Column(name = "Вид тесто")
//    @NotBlank
//    private String dough;

    @Column(name = "is_available")
    private boolean isAvailable = true;

    public Perfume() {
    }
//String dough,String size,
    public Perfume(Long id, String name, Double price, String imageUrl, String products, boolean isAvaiable) {
        this.id = id;
        this.name = name;
        //this.size = size;
        this.price = price;
        this.imageUrl = imageUrl;
        this.products = products;
       // this.dough = dough;
        this.isAvailable = isAvaiable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

//    public String getDough() {
//        return dough;
//    }
//
//    public void setDough(String dough) {
//        this.dough = dough;
//    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int compareTo(@NotNull Perfume o) {
        return this.id.compareTo(o.getId());
    }
}
