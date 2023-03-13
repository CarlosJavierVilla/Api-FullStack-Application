package com.FullStackApplication.Api.Models;

import java.util.UUID;

public class Sneaker {
    private UUID id;
    private String brand;
    private String model;
    private Double price;
    private String img;


    public Sneaker(String brand, String model, Double price, String img) {
        this.id = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.img = img;
    }

    public Sneaker() {
    }

    public UUID getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }
    public String getImg(){return img;}


    public void setId(UUID id){this.id = id;}

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public  void setImg(String  img){this.img = img;}
}
