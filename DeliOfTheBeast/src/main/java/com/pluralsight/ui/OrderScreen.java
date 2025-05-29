package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OrderScreen {
    private Scanner scanner = new Scanner(System.in);

    public Sandwich startOrder() {
        Order order = new Order();

        boolean ordering = true;
        while (ordering) {
            System.out.println("----- Order Screen ----");
            System.out.println(" Let's Build Your Feast ");
            System.out.println(" 1. Sandwich ");
            System.out.println(" 2. Add Drink ");
            System.out.println(" 3. Add Chips ");
            System.out.println(" 4. Checkout ");
            System.out.println(" 0. Cancel my Order ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Sandwich sandwich = buildSandwich();
                    order.addSandwich(sandwich);
                    System.out.println("Sandwich has been added! Current Total:  $" + order.totalPrice());
                    break;
                case "2":
                    order.setDrink(createDrink());
                    System.out.println("Thirst has been Quenched! Drink has been added. Current Total:  $" + order.totalPrice());

                    break;
                case "3":
                    order.setChips(createChips());
                    System.out.println("Lovely Choice! Chips has been added! Current Total:  $" + order.totalPrice());
                    break;
                case "4":
                    checkOut(order);
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        }
        return null;

    }

    private Sandwich buildSandwich () {
        System.out.println("Would you like White, Wheat, Rye, or a Wrap?");
        String bread = scanner.nextLine();

        System.out.println("Got It! Would you like a 4\"/8\"/12\"?");
        String size = scanner.nextLine();

        Sandwich sandwich = new Sandwich(bread, size);

        System.out.println("Let's add protein. Which meat would you like?");
        System.out.println("Steak | Ham | Salami | Roast Beef | Chicken | Bacon");
        String meat = scanner.nextLine();
        sandwich.setMeat(meat);

        System.out.println("Add extra meats one at a time (type 'done' to finish or skip):");
        while (true) {
            String inputExtra = scanner.nextLine();
            if (inputExtra.equalsIgnoreCase("done") || inputExtra.equals("0"))
                break;
            try {
                int extraMeat = Integer.parseInt(inputExtra);
                sandwich.addExtraMeat(extraMeat);
            } catch (NumberFormatException e) {
                System.out.println("Enter amount to add and type 'done' when finished or skip.");
            }
        }

        System.out.println("Let's add some cheese. Would you like American, Provolone, Cheddar, or Swiss?");
        String cheese = scanner.nextLine();
        sandwich.addCheese(cheese);

        System.out.println("Add extra cheeses one at a time (Press 'done' to finish or skip):");
        while (true) {
            String inputExtra = scanner.nextLine();
            if (inputExtra.equalsIgnoreCase("done") || inputExtra.equals("0"))
                break;
            try {
                int extraCheese = Integer.parseInt(inputExtra);
                sandwich.addExtraCheese(extraCheese);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter amount you'd like to add and hit 'done' when finished.");
            }
        }

        System.out.println("Let's add some toppings.Type 'done' to finish):");
        System.out.println("Lettuce | Peppers | Onions | Tomatoes | Jalapenos | Cucumbers | Pickles | Guac | Mushrooms");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done"))
                break;
            sandwich.addToppings(topping);
        }

        System.out.println("Would you like to add a sauce? (type 'done' to finish):");
        System.out.println("Mayo | Mustard | Ketchup | Ranch | Thousand Island | Vinaigrette");
        while (true) {
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("done"))
                break;
            sandwich.addSauce(sauce);
        }

        System.out.println("Would you like us to toast your sandwich? (yes/no)");
        String toasted = scanner.nextLine();
        sandwich.setToasted(toasted.equalsIgnoreCase("yes"));

        return sandwich;
    }


    private void checkOut(Order order) {
        double total = order.totalPrice();
        System.out.println("Ready to checkout?");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            createReceipt(order);

        } else {
            System.out.println("Order has been canceled");
        }


        System.out.println("Your total is:  $" + total);
        System.out.println("Thank you for Feasting at the Deli of the Beast!");
        System.out.println("See you next time!");

    }

    private Chips createChips() {
        System.out.println("Would you like to add some Lays or Doritos with that?");
        String chips = scanner.nextLine();
        return new Chips(chips);
    }

    private Drink createDrink() {
        System.out.println("Would you like to add a Drink? We have Coke products.");
        System.out.println("Coke | Orange Fanta | Gold Peak Tea | Sprite | Diet Coke | Dr. Pepper");
        String flavor = scanner.nextLine();
        System.out.println("Would you like a Small, Medium, or Large Drink?");
        String size = scanner.nextLine();

        return new Drink(size, flavor);
    }

    private void createReceipt(Order order) {
        try (BufferedWriter receipt = new BufferedWriter(new FileWriter("src/main/resources/receipt.csv", true))) {
            receipt.write("----- Your receipt from DeliOfTheBeast -----");


            for (Sandwich s : order.getSandwiches()) {
                receipt.write("  Meat: " + s.getMeat() + "\n");
                receipt.write(" Cheese " + s.getCheese() + "\n");
                receipt.write(" Extras - Meat: " + s.getExtraMeat() + ", Cheese: " + s.getExtraCheese() + "\n");
                receipt.write(" Toppings:  " + s.getToppings() + "\n");
                receipt.write(" Sauces:  " + s.getSauce() + "\n");
                receipt.write(" Toasted: " + s.isToasted() + "Yes :  No" + "\n");
                receipt.write(" Total Price :  $" + s.calculatePrice());

            }
            if (order.getDrink() != null) {
                receipt.write("Drink:  " + order.getDrink().getSize() + order.getDrink().getFlavor() + order.getDrink().getPrice());

            }
            if (order.getChips() != null) {
                receipt.write("Chips:   " + order.getChips().getType() + order.getChips().getPrice());
            }
            receipt.write("Total:  " + order.totalPrice());





        } catch (IOException e) {
            System.out.println("We couldn't print your receipt" + e.getMessage());
        }
    }

}






