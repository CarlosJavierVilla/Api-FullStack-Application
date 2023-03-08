package com.FullStackApplication.Api.models;

public class Sneaker {
    private long id;
    private String brand;
    private String model;
    private long price;


    public Sneaker(long id, String name, String model, long price) {
        this.id = id;
        this.brand = name;
        this.model = model;
        this.price = price;
    }

    public Sneaker() {
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public long getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}