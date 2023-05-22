package org.example;

public class BalanceCheck implements Transaction {

    public TransactionType getTransactionType() {
        return TransactionType.BALANCE_CHECK;
    }
    public void transactionOk() {
        System.out.println("Balance check successful");
    }

    public void transactionNoOk() {
        System.out.println("Balance check unsuccessful");
    }
}
