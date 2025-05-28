package com.pluralsight.util;

import com.pluralsight.models.Order;
import com.pluralsight.ui.OrderScreen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Receipt {
    public static void writeReceipt(Order order) {
        try (BufferedWriter write = new BufferedWriter(new FileWriter("src/main/resources/receipt.csv"))) {
            write.write("Order Receipt for Deli of the Beast");
            write.write("------------");
            write.write("Total:  $" + order.totalPrice());

        } catch (IOException e) {
            System.out.println("We couldn't write your receipt" + e.getMessage());
        }

    }
}
