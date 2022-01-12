package com.kinandcarta.domain;


public class Item implements ItemInterface {
    private String id;
    private String description;
    private int price;

    public Item(String id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }
    public String getDescription() {
        return this.description;
    }
    public int getPrice() {
        return this.price;
    }
}
