package com.FullStackApplication.Api.Models;

public class Sneaker {
    private long id;
    private String brand;
    private String model;
    private long price;
    private String img;


    public Sneaker(long id, String brand, String model, long price, String img) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.img = img;
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
    public String getImg(){return img;}

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
    public  void setImg(String  img){this.img = img;}
}
