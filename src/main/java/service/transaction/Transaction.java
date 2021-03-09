package service.transaction;

import common.InvalidRequestException;
import common.NotFoundException;
import service.entity.TransactionListResponse;
import service.entity.TransactionRequest;
import service.entity.TransactionResponse;

public interface Transaction {
    TransactionListResponse findAll() throws NotFoundException, InvalidRequestException;

    TransactionResponse findTransactionById(int transactionId) throws InvalidRequestException, NotFoundException;

    void createTransaction(TransactionRequest request) throws InvalidRequestException, NotFoundException;
}
