package com.pluralsight.models;

public class Chips {
    private String type;
    private double price = 1.50;

    public Chips(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
    public double getPrice() {
        return price;
    }
}
