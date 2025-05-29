package com.pluralsight.models;

public class Drink {

    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = this.flavor;
        this.price = price;

        switch (size) {
            case "Small":
                this.price = 2.00;
                break;
            case "Medium":
                this.price = 2.50;
                break;
            case "Large":
                this.price = 3.00;
                break;
            default:
                this.price = 0.0;
        }
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

}
