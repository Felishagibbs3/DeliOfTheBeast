package com.pluralsight.ui;

import java.util.Scanner;

public class HomeScreen {
    public void display() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        //Displays opening menu when entering store

        while (running) {
            System.out.println("--------------------------------------");
            System.out.println("Welcome to Deli of the BEAST!");
            System.out.println("--------------------------------------");
            System.out.println("READY TO FEAST?! LET'S GET STARTED!");
            System.out.println("--------------------------------------");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            String choice = scanner.nextLine();
            // if customer selects 1, you will be taken to the ordering screen to place the order

            if (choice.equals("1")) new OrderScreen().startOrder();
            else if (choice.equals("0"))
                break;

        }
    }
}
