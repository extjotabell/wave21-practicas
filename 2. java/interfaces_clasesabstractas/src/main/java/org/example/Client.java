package org.example;

import java.util.List;
import java.util.ArrayList;

// it might be better to call it Customer instead of client like paypal does
// has pointer error?
// El problema reside en cómo estás utilizando el método contains() de la clase List.
// Este método compara los objetos utilizando el método equals().
// En tu caso, estás comparando diferentes instancias de las clases que implementan la
// interfaz Transaction. Si no has sobrescrito el método equals() en tus clases de transacción,
// la comparación se realizará utilizando la igualdad de referencia (es decir, comparará
// si son exactamente la misma instancia), y no la igualdad de contenido.
//public abstract class Client {
//    protected List<Transaction> availableTransactions;
//
//    public Client() {
//        this.availableTransactions = new ArrayList<>();
//    }
//
//    public void doTransaction(Transaction transaction) {
//        System.out.println("transaction");
//        System.out.println(transaction);
//        System.out.println("availableTransactions.contains(transaction)");
//        System.out.println(availableTransactions.contains(transaction));
//
//        availableTransactions.
//        if(availableTransactions.contains(transaction)) {
//            transaction.transactionOk();
//        } else {
//            transaction.transactionNoOk();
//        }
//    }
//}

public abstract class Client {
    protected List<TransactionType> availableTransactions;

    public Client() {
        this.availableTransactions = new ArrayList<>();
    }

    public void doTransaction(Transaction transaction) {
        //System.out.println("transaction");
        //System.out.println(transaction); // org.example.Deposit@279f2327
        //System.out.println("transaction.getTransactionType()");
        //System.out.println(transaction.getTransactionType()); // DEPOSIT, ...

        if(availableTransactions.contains(transaction.getTransactionType())) {
            transaction.transactionOk();
        } else {
            transaction.transactionNoOk();
        }
    }
}
