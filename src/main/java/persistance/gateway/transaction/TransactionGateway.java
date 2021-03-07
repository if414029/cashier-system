package persistance.gateway.transaction;

import persistance.entity.Item;
import persistance.entity.Transaction;

import java.util.List;

public interface TransactionGateway {
    List<Transaction> findAll();

    Transaction findTransactionById(int transactionId);

    void createTransaction(Transaction transaction);
}
