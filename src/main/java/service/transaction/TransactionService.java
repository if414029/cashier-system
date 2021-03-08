package service.transaction;

import common.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import persistance.gateway.transaction.TransactionGateway;
import service.entity.TransactionListResponse;
import service.entity.TransactionRequest;
import service.entity.TransactionResponse;

public class TransactionService implements Transaction {

    @Autowired
    private final TransactionGateway gateway;

    public TransactionService(TransactionGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public TransactionListResponse findAll() {
        return gateway.findAll();
    }

    @Override
    public TransactionResponse findTransactionById(int transactionId) throws InvalidRequestException {
        validateRequestId(transactionId);
        return gateway.findTransactionById(transactionId);
    }

    private void validateRequestId(int transactionId) throws InvalidRequestException {
        if (transactionId < 0) {
            throw new InvalidRequestException("Id can't be lower than 0");
        }
    }

    @Override
    public void createTransaction(TransactionRequest request) throws InvalidRequestException {
        validateRequest(request);
        gateway.createTransaction(request);
    }

    private void validateRequest(TransactionRequest request) throws InvalidRequestException {
        if (request == null) {
            throw new InvalidRequestException("Request can't be null!");
        }

        if (request.getCustomerId() < 0) {
            throw new InvalidRequestException("CustomerId Name can't be lower than 0!");
        }

        if (request.getItems() == null) {
            throw new InvalidRequestException("Items can't be null!");
        }

        if (request.getPaymentTypeCode() == null) {
            throw new InvalidRequestException("PaymentTypeCode Name can't be null!");
        }
    }
}
