package persistance.gateway.transaction;

import common.NotFoundException;
import persistance.entity.Transaction;
import persistance.repository.TransactionRepository;
import service.entity.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransactionJPAGateway implements TransactionGateway {

    private final TransactionRepository repository;

    public TransactionJPAGateway(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransactionListResponse findAll() {
        List<Transaction> transactionList = repository.findAll();
        return constructTransactionListResponse(transactionList);
    }

    private TransactionListResponse constructTransactionListResponse(List<Transaction> transactionList) {
        TransactionListResponse transactionListResponse = new TransactionListResponse();

        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(Transaction transaction : transactionList){
            transactionResponses.add(constructTransactionResponse(transaction));
        }

        transactionListResponse.setListTransaction(transactionResponses);

        return transactionListResponse;
    }

    @Override
    public TransactionResponse findTransactionById(int transactionId) throws NotFoundException {
        return repository.findById(transactionId)
                .map(this::constructTransactionResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + transactionId));
    }

    @Override
    public void createTransaction(TransactionRequest request) {
        Transaction entity = getTransactionEntity(request);
        repository.save(entity);
    }

    private Transaction getTransactionEntity(TransactionRequest request) {
        Transaction entity = new Transaction();
        entity.setDescription(request.getDescription());
        entity.setCustomerId(request.getCustomerId());
        entity.setItemId(request.getItems());
        entity.setPurchaseDate(Date.valueOf(request.getPurchaseDate()));
        entity.setTotalPrice(request.getTotalPrice());
        entity.setPaymentTypeCode(request.getPaymentTypeCode());

        return entity;
    }

    private TransactionResponse constructTransactionResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setDescription(transaction.getDescription());
        response.setPurchaseDate(String.valueOf(transaction.getPurchaseDate()));
        response.setTotalPrice(transaction.getTotalPrice());
        response.setTransactionId(transaction.getTransactionId());
        response.setCustomerId(transaction.getCustomerId());
        response.setItems(transaction.getItemId());
        response.setPaymentTypeCode(transaction.getPaymentTypeCode());

        return response;
    }
}
