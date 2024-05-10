package com.perfumery.perfumerywebapp.bootstrap;

public class ParsedPerfume {

    private String name;
   // private String size;
    private double price;
    private String products;
   // private String dough;
    private String imageUrl;
    private Long quantity;
    private boolean isAvailable;

    public ParsedPerfume() {
    }
//String dough,String size,
    public ParsedPerfume(String name, double price, String products, String imageUrl, Long quantity, boolean isAvailable) {
        this.name = name;
       // this.size = size;
        this.price = price;
        this.products = products;
       // this.dough = dough;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }
}
