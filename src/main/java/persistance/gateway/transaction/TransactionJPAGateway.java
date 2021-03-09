package persistance.gateway.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import persistance.entity.Transaction;
import persistance.gateway.customer.CustomerGateway;
import persistance.gateway.item.ItemGateway;
import persistance.gateway.paymentType.PaymentTypeGateway;
import persistance.repository.TransactionRepository;
import service.entity.TransactionListResponse;
import service.entity.TransactionRequest;
import service.entity.TransactionResponse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class TransactionJPAGateway implements TransactionGateway {
    
    @Autowired
    private TransactionRepository repository;
    private final ItemGateway itemGateway;
    private final CustomerGateway customerGateway;
    private final PaymentTypeGateway paymentTypeGateway;

    public TransactionJPAGateway(ItemGateway itemGateway, CustomerGateway customerGateway, PaymentTypeGateway paymentTypeGateway) {
        this.itemGateway = itemGateway;
        this.customerGateway = customerGateway;
        this.paymentTypeGateway = paymentTypeGateway;
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
    public TransactionResponse findTransactionById(int transactionId) {
        return null;
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


        return response;
    }
}
