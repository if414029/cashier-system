package persistance.gateway.transaction;

import common.NotFoundException;
import persistance.entity.Item;
import persistance.entity.Transaction;
import service.entity.TransactionListResponse;
import service.entity.TransactionRequest;
import service.entity.TransactionResponse;

import java.util.List;

public interface TransactionGateway {
    TransactionListResponse findAll();

    TransactionResponse findTransactionById(int transactionId) throws NotFoundException;

    void createTransaction(TransactionRequest request);
}
