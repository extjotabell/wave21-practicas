package org.example;

public class CashWithdrawal implements Transaction {

    public TransactionType getTransactionType() {
        return TransactionType.CASH_WITHDRAWAL;
    }
    public void transactionOk() {
        System.out.println("Cash withdrawal successful");
    }

    public void transactionNoOk() {
        System.out.println("Cash withdrawal unsuccessful");
    }
}
