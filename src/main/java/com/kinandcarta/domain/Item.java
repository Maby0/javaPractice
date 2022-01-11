package com.kinandcarta.domain;

/**
 * Defines an item that can be purchased from the store.
 */
public class Item implements ItemInterface {

    // Define a private field for the item id.
    private String id;
    // Define a private field for the item description.
    private String description;
    // Define a private field for the price.
    private int price;
    // Define a constructor which will take values for all three fields as parameters and assign them to the fields.
    public Item(String id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }
    // Add 'get' methods that will allow external access to the fields.
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
