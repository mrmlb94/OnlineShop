package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shopdb")
public class ShopItem {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity;


    public ShopItem() {
    }

    public ShopItem(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @SuppressWarnings("unused")
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    @SuppressWarnings("unused")
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
