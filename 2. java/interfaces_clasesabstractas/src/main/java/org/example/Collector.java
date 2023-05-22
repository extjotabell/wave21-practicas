package org.example;

public class Collector extends Client {
    public Collector() {
        super();
        //availableTransactions.add(new CashWithdrawal());
        //availableTransactions.add(new BalanceCheck());

        availableTransactions.add(TransactionType.CASH_WITHDRAWAL);
        availableTransactions.add(TransactionType.BALANCE_CHECK);
    }
}