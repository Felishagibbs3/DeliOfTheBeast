package com.pluralsight;

import com.pluralsight.ui.HomeScreen;
import com.pluralsight.ui.OrderScreen;

public class Program {
    public static void main(String[] args) {
        HomeScreen home = new HomeScreen();
        home.display();
        OrderScreen screen = new OrderScreen();
        screen.startOrder();
    }
}
