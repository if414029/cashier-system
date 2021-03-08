package persistance.gateway.transaction;

import persistance.entity.Item;
import persistance.entity.Transaction;
import service.entity.TransactionListResponse;
import service.entity.TransactionRequest;
import service.entity.TransactionResponse;

import java.util.List;

public interface TransactionGateway {
    TransactionListResponse findAll();

    TransactionResponse findTransactionById(int transactionId);

    void createTransaction(TransactionRequest request);
}
