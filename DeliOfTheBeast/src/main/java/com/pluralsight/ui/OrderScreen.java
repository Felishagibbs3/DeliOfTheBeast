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
            System.out.println("----- Let's Start Your Order ----");
            System.out.println(" Select your option ");
            System.out.println(" 1. Sandwich ");
            System.out.println(" 2. Add Drink ");
            System.out.println(" 3. Add Chips ");
            System.out.println(" 4. Checkout ");
            System.out.println(" 0. Cancel my Order ");

            String choice = scanner.nextLine();
            Sandwich sandwich;

            switch (choice) {
                case "1":
                    System.out.println("Would you like White, Wheat, Rye, or a Wrap?");
                    String bread = scanner.nextLine();

                    System.out.println("Got It! Would you like a 4\"/8\"/12\"?):  ");
                    String size = scanner.nextLine();

                    sandwich = new Sandwich(bread, size);

                    System.out.println("Would you like Steak, Ham, Salami, Roast Beef, Chicken, or Bacon as your meat?");
                    while (ordering) {
                        String meat = scanner.nextLine();
                        if (meat.equalsIgnoreCase("done"))
                            break;
                        sandwich.addMeat(meat);
                    }
                    System.out.println("Would you like to add extra meat?");
                    int extraMeat = Integer.parseInt(scanner.nextLine());
                    sandwich.addMeat(extraMeat);

                    System.out.println("Let's add some cheese. Would you like American, Provolone, Cheddar, or Swiss?");
                    while (ordering) {
                        String cheese = scanner.nextLine();
                        if (cheese.equalsIgnoreCase("added cheese"))
                            break;
                        String extraCheese = "";
                        sandwich.addCheese(extraCheese);
                    }
                    System.out.println("Would you like extra cheese?");
                    int extraCheese = Integer.parseInt(scanner.nextLine());
                    sandwich.getExtraCheese();

                    System.out.println("Let's add some toppings now. What topping would you like? We have Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Picles, Guac, or Mushrooms?");
                    while (ordering) {
                        String toppings = scanner.nextLine();
                        if (toppings.equalsIgnoreCase("Added toppings"))
                            break;
                        sandwich.addToppings(toppings);
                    }
                    System.out.println("Would you like to add some Mayo, Mustard, Ketchup, Ranch, Thousand Island, or Vinaigrette?");
                    while (ordering) {
                        String sauce = scanner.nextLine();
                        if (sauce.equalsIgnoreCase("Sauce me up, please!"))
                        sandwich.addSauce(sauce);
                        break;
                    }
                    System.out.println("Would you like for us to toast your sandwich?");
                    String toasted = scanner.nextLine();
                    sandwich.setToasted(toasted.equalsIgnoreCase("Absolutely"));
                    return sandwich;
                case "2":
                    order.setDrink(createDrink());
                    break;
                case "3":
                    order.setChips(createChips());
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

    private void checkOut(Order order) {
        double total = order.totalPrice();
        System.out.println("Ready to checkout?");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            createReceipt(order);
            System.out.println("Order Received. We are printing your receipt");
        } else {
            System.out.println("Order has been canceled");
        }

        System.out.println("Your total is:  $" + total);

    }

    private Chips createChips() {
        System.out.println("Would you like to add some Lays or Doritos with that?");
        String chips = scanner.nextLine();
        return new Chips("");
    }

    private Drink createDrink() {
        System.out.println("Would you like to add a Drink? We have Coke products.");
        String flavor = scanner.nextLine();
        System.out.println("Would you like a Small, Medium, or Large Drink?");
        String size = scanner.nextLine();

        return new Drink(size + flavor);
    }

    private void createReceipt(Order order) {
        try (BufferedWriter receipt = new BufferedWriter(new FileWriter("src/main/resources/receipt.csv", true))) {
            receipt.write("----- Your receipt from DeliOfTheBeast -----");


            for (Sandwich s : order.getSandwiches()) {
                receipt.write("  Meat: " + s.getMeat());
                receipt.write(" Cheese " + s.getCheese());
                receipt.write(" Extras: " + s.getExtraMeat() + s.getExtraCheese());
                receipt.write(" Toppings:  " + s.getToppings());
                receipt.write(" Sauces:  " + s.getSauce());
                receipt.write(" Toasted: " + s.isToasted() + "Yes :  No");
                receipt.write(" Total Price :  $" + s.calculatePrice());

            }
            if (order.getDrink() != null) {
                receipt.write("Drink:  " + order.getDrink().getSize() + order.getDrink().getFlavor() + order.getDrink().getPrice());

            }
            if (order.getChips() != null) {
                receipt.write("Chips:   " + order.getChips().getType() + order.getChips().getPrice());
            }
            receipt.write("Total:  " + order.totalPrice());

            System.out.println("Thank you for eating at Deli of the Beast!");


        } catch (IOException e) {
            System.out.println("We couldn't print your receipt" + e.getMessage());
        }
    }

    public String totalPrice() {
    }
}






