package com.amos.chasiersystem.persistance.gateway.transaction;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.TransactionListResponse;
import com.amos.chasiersystem.service.entity.TransactionRequest;
import com.amos.chasiersystem.service.entity.TransactionResponse;

public interface TransactionGateway {
    TransactionListResponse findAll();

    TransactionResponse findTransactionById(int transactionId) throws NotFoundException;

    void createTransaction(TransactionRequest request);
}
