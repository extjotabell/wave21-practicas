package org.example;

import java.util.Arrays;
import java.util.List;

public class Distributor {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Perishable("Milk", 1.5, 1),
                new Perishable("Cheese", 2.5, 2),
                new NonPerishable("Canned beans", 1.2, "Canned goods"),
                new NonPerishable("Rice", 0.8, "Grains")
        );

        int productQuantity = 5;
        double totalPrice = 0;

        for (Product product : products) {
            totalPrice += product.calculate(productQuantity);
        }

        System.out.println("Total price for selling 5 products of each type: " + totalPrice);
    }
}

