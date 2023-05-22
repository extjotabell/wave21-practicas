package org.example;

public class ServicePayment implements Transaction {

    public TransactionType getTransactionType() {
        return TransactionType.SERVICE_PAYMENT;
    }
    public void transactionOk() {
        System.out.println("Service payment successful");
    }

    public void transactionNoOk() {
        System.out.println("Service payment unsuccessful");
    }
}