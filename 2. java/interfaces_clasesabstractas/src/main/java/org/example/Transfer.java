package org.example;

public class Transfer implements Transaction {

    public TransactionType getTransactionType() {
        return TransactionType.TRANSFER;
    }
    public void transactionOk() {
        System.out.println("Transfer successful");
    }

    public void transactionNoOk() {
        System.out.println("Transfer unsuccessful");
    }
}
