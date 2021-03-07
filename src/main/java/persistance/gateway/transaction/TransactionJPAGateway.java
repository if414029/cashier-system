package persistance.gateway.transaction;

import persistance.entity.Transaction;

import java.util.List;

public class TransactionJPAGateway implements TransactionGateway{
    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction findTransactionById(int transactionId) {
        return null;
    }

    @Override
    public void createTransaction(Transaction transaction) {

    }
}
