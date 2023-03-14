package com.FullStackApplication.Api.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Sneaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private UUID uuid;
    private String brand;
    private String model;
    private Double price;
    private String img;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }


    public Sneaker(String brand, String model, Double price, String img) {
        this.uuid = UUID.randomUUID();
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.img = img;
    }

    public Sneaker() {
        this.uuid = UUID.randomUUID();
    }
    public UUID getUuid() {
        return uuid;
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
    public void setUuid(UUID uuid){this.uuid = uuid;}
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
