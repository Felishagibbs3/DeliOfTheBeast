package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private Drink drink;
    private Chips chips;

    public Order(List<Sandwich> sandwiches, Drink drink, Chips chips) {
        this.sandwiches = sandwiches;
        this.drink = drink;
        this.chips = chips;
    }

    public Order() {

    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public void addSandwich (Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public double totalPrice(){
        double total = 0.0;

        for (Sandwich s : sandwiches){
            total += s.calculatePrice();
        }
        if (drink != null) {
            total += drink.getPrice();
        }
        if (chips != null) {
            total += chips.getPrice();
        }
        return total;
    }
}
