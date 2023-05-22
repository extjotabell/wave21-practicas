package org.example;

public class Executive extends Client {
    public Executive() {
        super();
        //availableTransactions.add(new Deposit());
        //availableTransactions.add(new Transfer());

        availableTransactions.add(TransactionType.DEPOSIT);
        availableTransactions.add(TransactionType.TRANSFER);
    }
}
