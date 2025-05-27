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

    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.size = size;
    }
    public void addMeat(String meats) {
        meat.add(meats);
    }

    public double calculatePrice() {
    }
}
