package com.pluralsight.models;

public class Toppings {
    private String name;

    public Toppings(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public class addToppings{
        public static Toppings createToppings(String name) {
            switch (name.toLowerCase()) {
                case "lettuce":
                case "tomatoes":
                case "jalapenos":
                case "cucumbers":
                case "guac":
                case "peppers":
                case "onions":
                case "mushrooms":
                case "pickles":

            }

            return new Toppings(name);
        }
    }
}
