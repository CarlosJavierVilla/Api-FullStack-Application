package com.FullStackApplication.Api.Models;

import java.util.UUID;

public class Shoe {

    private UUID id;
    private String model;
    private Integer size;
    private String color;

    public Shoe(UUID id, String model, Integer size, String color) {
        this.id = UUID.randomUUID();
        this.model = model;
        this.size = size;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Integer getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
