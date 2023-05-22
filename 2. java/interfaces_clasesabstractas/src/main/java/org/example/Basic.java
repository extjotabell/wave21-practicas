package org.example;

public class Basic extends Client {
    public Basic() {
        super();
        //availableTransactions.add(new BalanceCheck());
        //availableTransactions.add(new ServicePayment());
        //availableTransactions.add(new CashWithdrawal());

        availableTransactions.add(TransactionType.BALANCE_CHECK);
        availableTransactions.add(TransactionType.SERVICE_PAYMENT);
        availableTransactions.add(TransactionType.CASH_WITHDRAWAL);
    }
}
