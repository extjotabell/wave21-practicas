package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Exercise 1
        //ExceptionPractice newEP = new ExceptionPractice();
        try {
            //newEP.calculateQuotient();
            new ExceptionPractice().calculateQuotient();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Exercise 2
        Distributor.main(args);

        System.out.println("flow flow");
    }
}
