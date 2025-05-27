package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String bread;
    private String size;
    private boolean toasted;
    private List<String> meat = new ArrayList<>();
    private List<String> cheese = new ArrayList<>();
    private List<String> toppings = new ArrayList<>();
    private List<String> sauce = new ArrayList<>();
    private int extraMeat = 0;
    private int extraCheese = 0;

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<String> getMeat() {
        return meat;
    }

    public void setMeat(List<String> meat) {
        this.meat = meat;
    }

    public List<String> getCheese() {
        return cheese;
    }

    public void setCheese(List<String> cheese) {
        this.cheese = cheese;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public List<String> getSauce() {
        return sauce;
    }

    public void setSauce(List<String> sauce) {
        this.sauce = sauce;
    }

    public int getExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(int extraMeat) {
        this.extraMeat = extraMeat;
    }

    public int getExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(int extraCheese) {
        this.extraCheese = extraCheese;
    }

    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.size = size;


    }

    public void addMeat(String meats) {
        meat.add(meats);
    }

    public double calculatePrice() {
        double price = 0.0;

        switch (size) {
            case "4\"":
                price += 5.50;
                break;
            case "8\"":
                price += 7.00;
                break;
            case "12\"":
                price = +8.50;
                break;
        }

        double meatPrice = switch (size) {
            case "4\"" -> 1.00;
            case "8\"" -> 2.00;
            case "12\"" -> 3.00;
            default -> 0.0;
        };
        price += meat.size() * meatPrice;
        double extraMeatPrice = switch (size) {
            case "4\"" -> 0.50;
            case "8\"" -> 1.00;
            case "12\"" -> 1.50;
            default -> 0.0;
        };
        price += extraMeat * extraMeatPrice;

        double cheesePrice = switch (size) {
            case "4\"" -> 0.75;
            case "8\"" -> 1.50;
            case "12\"" -> 2.25;
            default -> 0.0;
        };
        price += cheese.size() * cheesePrice;

        double extraCheesePrice = switch (size) {
            case "4\"" -> 0.30;
            case "8\"" -> 0.60;
            case "12\"" -> 0.90;
            default -> 0.0;
        };
        price += extraCheese * extraCheesePrice;


        return price;
    }
}
