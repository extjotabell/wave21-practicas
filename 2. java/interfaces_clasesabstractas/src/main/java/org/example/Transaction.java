package org.example;

public interface Transaction {

    TransactionType getTransactionType();
    void transactionOk();
    void transactionNoOk();
}