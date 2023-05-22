package org.example;

public class Deposit implements Transaction {

    public TransactionType getTransactionType() {
        return TransactionType.DEPOSIT;
    }
    public void transactionOk() {
        System.out.println("Deposit successful");
    }

    public void transactionNoOk() {
        System.out.println("Deposit unsuccessful");
    }
}
