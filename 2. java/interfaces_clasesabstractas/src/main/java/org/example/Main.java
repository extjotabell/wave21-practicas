package org.example;

import java.util.Arrays;
import java.util.List;

// Main o Bank
public class Main {
    public static void main(String[] args) {
//          // EXERCISE 2
//        // Create clients
//        Executive executiveClient = new Executive();
//        Basic basicClient = new Basic();
//        Collector collectorClient = new Collector();
//
//        // Create transactions
//        Deposit depositTransaction = new Deposit();
//        Transfer transferTransaction = new Transfer();
//        CashWithdrawal cashWithdrawalTransaction = new CashWithdrawal();
//        BalanceCheck balanceCheckTransaction = new BalanceCheck();
//        ServicePayment servicePaymentTransaction = new ServicePayment();
//
//        // Execute transactions with executive client
//        System.out.println("Executive Client Transactions:");
//        executiveClient.doTransaction(depositTransaction);
//        executiveClient.doTransaction(transferTransaction);
//        executiveClient.doTransaction(cashWithdrawalTransaction); // This should be unsuccessful
//        executiveClient.doTransaction(balanceCheckTransaction); // This should be unsuccessful
//        executiveClient.doTransaction(servicePaymentTransaction); // This should be unsuccessful
//
//        // Execute transactions with basic client
//        System.out.println("\nBasic Client Transactions:");
//        basicClient.doTransaction(depositTransaction); // This should be unsuccessful
//        basicClient.doTransaction(transferTransaction); // This should be unsuccessful
//        basicClient.doTransaction(cashWithdrawalTransaction);
//        basicClient.doTransaction(balanceCheckTransaction);
//        basicClient.doTransaction(servicePaymentTransaction);
//
//        // Execute transactions with collector client
//        System.out.println("\nCollector Client Transactions:");
//        collectorClient.doTransaction(depositTransaction); // This should be unsuccessful
//        collectorClient.doTransaction(transferTransaction); // This should be unsuccessful
//        collectorClient.doTransaction(cashWithdrawalTransaction);
//        collectorClient.doTransaction(balanceCheckTransaction);
//        collectorClient.doTransaction(servicePaymentTransaction); // This should be unsuccessful

//        // EXERCISE 2
//        // Create documents
//        exercise2.Curriculum curriculum = new exercise2.Curriculum("John Doe, Software Developer", Arrays.asList("Java", "Python", "C++"));
//        exercise2.PdfBook pdfBook = new exercise2.PdfBook(200, "J.K. Rowling", "Harry Potter and the Philosopher's Stone", "Fantasy");
//        exercise2.Report report = new exercise2.Report("This is a report.", 10, "John Doe", "Jane Doe");
//
//        // Print documents
//        curriculum.print();
//        pdfBook.print();
//        report.print();

        // EXERCISE 3
        exercise3.Dog dog = new exercise3.Dog();
        exercise3.Cat cat = new exercise3.Cat();
        exercise3.Cow cow = new exercise3.Cow();

        dog.makeSound();
        dog.eatMeat();

        cat.makeSound();
        cat.eatMeat();

        cow.makeSound();
        cow.eatGrass();

        dog.eatAnimal(cat);
        dog.eatAnimal(cow);
        cat.eatAnimal(dog);
        cat.eatAnimal(cow);
    }
}