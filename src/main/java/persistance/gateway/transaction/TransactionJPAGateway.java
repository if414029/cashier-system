package persistance.gateway.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import persistance.entity.Transaction;
import persistance.repository.TransactionRepository;
import service.entity.TransactionListResponse;
import service.entity.TransactionRequest;
import service.entity.TransactionResponse;

import java.util.ArrayList;
import java.util.List;

public class TransactionJPAGateway implements TransactionGateway {
    
    @Autowired
    private TransactionRepository repository;
    
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
    public TransactionResponse findTransactionById(int transactionId) {
        return null;
    }

    @Override
    public void createTransaction(TransactionRequest request) {

    }

    private TransactionResponse constructTransactionResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();


        return response;
    }
}
