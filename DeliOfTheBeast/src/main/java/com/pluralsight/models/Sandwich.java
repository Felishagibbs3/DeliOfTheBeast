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
        return this.extraCheese;
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
        return 0;
    }

    public void addCheese(String cheese) {
    }

    public void addMeat(int extraMeat) {
    }

    public void addToppings(String toppings) {
    }

    public void addSauce(String sauce) {
    }


    public void addExtraMeat(String extraMeat) {
    }

    public void addExtraCheese(String extraCheese) {
    }
}

