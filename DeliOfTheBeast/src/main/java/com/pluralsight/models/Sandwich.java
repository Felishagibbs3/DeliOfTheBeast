package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    public boolean signature;
    private String bread;
    private String size;
    private boolean toasted;
    private String meat;
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

    public Sandwich(boolean isSignature) {
        this.signature = isSignature;
    }

    public boolean isSignature() {
        return signature;
    }

    public void setSignature(boolean signature) {
        this.signature = signature;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
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
        return this.extraCheese;
    }

    public void setExtraCheese(int extraCheese) {
        this.extraCheese = extraCheese;
    }

    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.size = size;
        this.signature = false;


    }

    public void addMeat(String meats) {
        this.meat = meats;
    }

    public double calculatePrice() {
        double basePrice;

        switch (size) {
            case "4\"": basePrice = 5.0;
            break;
            case "8\"": basePrice = 7.0;
            break;
            case "12\"": basePrice = 9.0;
            break;
            default:
                basePrice = 7.0; break;
        }

        basePrice += extraMeat * 1.5;  // each extra meat $1.50
        basePrice += extraCheese * 1.0;  // each extra cheese $1.00

        return basePrice;

    }

    public void addCheese(String cheese) {
        this.cheese.add(cheese);
    }


    public void addToppings(String toppings) {
        this.toppings.add(toppings);
    }

    public void addSauce(String sauce) {
        this.sauce.add(sauce);
    }


    public void addExtraMeat(int extraMeat) {
        this.extraMeat += extraMeat;
    }

    public void addExtraCheese(int extraCheese) {
        this.extraCheese += extraCheese;
    }
}

