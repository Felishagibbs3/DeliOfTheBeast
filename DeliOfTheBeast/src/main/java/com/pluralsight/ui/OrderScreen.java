package com.pluralsight.ui;

import com.pluralsight.models.Order;

import java.util.Scanner;

public class OrderScreen {
    private Scanner scanner = new Scanner(System.in);
    public void startOrder() {
        Order order = new Order("", "", "");

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

        }

    }
}
