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

    //using a scanner to gather customer's choice and began a start order method that
    //comes up after selecting '1' on Home Screen

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
            System.out.println(" 5. Signature Sandwich Meals ");
            System.out.println(" 0. Cancel my Order ");

            String choice = scanner.nextLine();

            //using the switch statements to offer an effective way to navigate through choice options

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
                case "5":
                    Sandwich signature = selectSignatureSandwich();
                    order.addSandwich(signature);
                    System.out.println("Signature Sandwich has been added! Current Total:  $" + order.totalPrice());
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
    // method for creating the signature sandwich options,
    // also utilizing a switch statement to make for easier selection

    private Sandwich selectSignatureSandwich() {
        System.out.println("Choose your Signature Sandwich:");
        System.out.println("1. Feed the Beast (Steak, Cheddar, Jalapenos, Chipotle Mayo)");
        System.out.println("2. Home in the Garden (Wrap, Swiss, Lettuce, Cucumbers, Tomatoes, Vinaigrette)");
        System.out.println("3. Showdown in Italy (Salami, Provolone, Peppers, Italian Dressing)");

        String choice = scanner.nextLine();
        Sandwich sandwich;
        // each case breaks down how the signature sandwich will be created
        // from size of sandiwch, toppings, meat, cheese, and sauces/dressings

        switch (choice) {
            case "1":
                sandwich = new Sandwich("White", "12\"");
                sandwich.setMeat("Steak");
                sandwich.addCheese("Cheddar");
                sandwich.addToppings("Jalapenos");
                sandwich.addSauce("Chipotle Mayo");
                sandwich.setToasted(true);
                sandwich.setSignature(true);
                break;
            case "2":
                sandwich = new Sandwich("Wrap", "8\"");
                sandwich.setMeat("None");
                sandwich.addCheese("Swiss");
                sandwich.addToppings("Lettuce");
                sandwich.addToppings("Cucumbers");
                sandwich.addToppings("Tomatoes");
                sandwich.addSauce("Vinaigrette");
                sandwich.setToasted(false);
                sandwich.setSignature(true);
                break;
            case "3":
                sandwich = new Sandwich("Wheat", "12\"");
                sandwich.setMeat("Salami");
                sandwich.addCheese("Provolone");
                sandwich.addToppings("Peppers");
                sandwich.addSauce("Italian Dressing");
                sandwich.setSignature(true);
                sandwich.setToasted(true);
                break;
            default:
                System.out.println("Invalid choice, defaulting to Well Balanced Beast.");
                sandwich = new Sandwich("Wrap", "8\"");
                sandwich.setMeat("Chicken");
                sandwich.addCheese("Swiss");
                sandwich.addToppings("Tomatoes");
                sandwich.addToppings("Peppers");
                sandwich.addToppings("Lettuce");
                sandwich.addSauce("Vinaigrette");
                sandwich.setToasted(false);
                break;
        }

        return sandwich;
    }
    // this method is for building a Create Your Own Style Sandwich

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
        //when adding extra, use an int to add the number of meat they want to add
        // ex: extra steak = 1x extra or 2x extra

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

        // same method applies here for cheese.
        // using int to display the number of how much extra cheese they'd like

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
        //using a boolean to define if it is toasted or not,
        // and will return either true or false on receipt

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

        } else {
            System.out.println("Order has been canceled");
        }
        createReceipt(order);


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
            receipt.write("\n" + "----- Your receipt from DeliOfTheBeast -----" + "\n");


            for (Sandwich s : order.getSandwiches()) {
                receipt.write(" Signature Sandwich: " + s.isSignature() + "\n");
                receipt.write(" Meat: " + s.getMeat() + "\n");
                receipt.write(" Cheese " + s.getCheese() + "\n");
                receipt.write(" Extras - Meat: " + s.getExtraMeat() + " " + ", Cheese: " + s.getExtraCheese() + "\n");
                receipt.write(" Toppings:  " + s.getToppings() + "\n");
                receipt.write(" Sauces:  " + s.getSauce() + "\n");
                receipt.write(" Toasted: " + s.isToasted()  + "\n");


            }
            if (order.getDrink() != null) {
                receipt.write(" Drink:  " + order.getDrink().getSize() + " " + "$" +order.getDrink().getPrice() + "\n");

            }
            if (order.getChips() != null) {
                receipt.write(" Chips:   " + order.getChips().getType() + " " + "$" + order.getChips().getPrice() + "\n");
            }
            receipt.write(" Total:  " + order.totalPrice());


        } catch (IOException e) {
            System.out.println("We couldn't print your receipt" + e.getMessage());
        }
    }

}






