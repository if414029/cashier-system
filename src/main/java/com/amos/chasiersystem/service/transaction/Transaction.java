package com.amos.chasiersystem.service.transaction;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.TransactionDataRequest;
import com.amos.chasiersystem.service.entity.TransactionListResponse;
import com.amos.chasiersystem.service.entity.TransactionRequest;
import com.amos.chasiersystem.service.entity.TransactionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface Transaction {
    TransactionListResponse findAll() throws NotFoundException, InvalidRequestException;

    TransactionResponse findTransactionById(int transactionId) throws InvalidRequestException, NotFoundException;

    void createTransaction(TransactionDataRequest request) throws InvalidRequestException, NotFoundException, JsonProcessingException;
}
