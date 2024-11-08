package com.example.mylistview;

public class Currency {
    private String name;
    private double price;

    public Currency(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
