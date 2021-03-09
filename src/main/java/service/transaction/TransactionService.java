package service.transaction;

import common.InvalidRequestException;
import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistance.gateway.customer.CustomerGateway;
import persistance.gateway.item.ItemGateway;
import persistance.gateway.paymentType.PaymentTypeGateway;
import persistance.gateway.transaction.TransactionGateway;
import service.entity.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements Transaction {

    @Autowired
    private final TransactionGateway gateway;
    private final CustomerGateway customerGateway;
    private final ItemGateway itemGateway;
    private final PaymentTypeGateway paymentTypeGateway;

    public TransactionService(TransactionGateway gateway, CustomerGateway customerGateway, ItemGateway itemGateway, PaymentTypeGateway paymentTypeGateway) {
        this.gateway = gateway;
        this.customerGateway = customerGateway;
        this.itemGateway = itemGateway;
        this.paymentTypeGateway = paymentTypeGateway;
    }

    @Override
    public TransactionListResponse findAll() throws NotFoundException, InvalidRequestException {
        TransactionListResponse transactionListResponse = gateway.findAll();
        return constructTransactionListResponse(transactionListResponse);
    }

    @Override
    public TransactionResponse findTransactionById(int transactionId) throws InvalidRequestException, NotFoundException {
        validateRequestId(transactionId);
        TransactionResponse transactionResponse = gateway.findTransactionById(transactionId);
        return constructTransactionResponse(transactionResponse);
    }

    @Override
    public void createTransaction(TransactionRequest request) throws InvalidRequestException, NotFoundException {
        validateRequest(request);
        setItemsCustomerAndPaymentTypeRequest(request);
        gateway.createTransaction(request);
    }

    private TransactionListResponse constructTransactionListResponse(TransactionListResponse transactionListResponse) throws NotFoundException, InvalidRequestException {
        TransactionListResponse response = new TransactionListResponse();

        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(TransactionResponse transactionResponse : transactionListResponse.getListTransaction()){
            transactionResponses.add(constructTransactionResponse(transactionResponse));
        }
        transactionListResponse.setListTransaction(transactionResponses);

        return response;
    }

    private TransactionResponse constructTransactionResponse(TransactionResponse transactionResponse) throws NotFoundException, InvalidRequestException {

        TransactionResponse transaction = gateway.findTransactionById(transactionResponse.getTransactionId());
        transactionResponse.setTransactionId(transaction.getTransactionId());

        CustomerResponse customer = customerGateway.findCustomerById(transaction.getCustomerId());
        transactionResponse.setCustomer(customer);

        PaymentTypeResponse paymentType = paymentTypeGateway.findPaymentTypeByPaymentTypeCode(transaction.getPaymentTypeCode());
        transaction.setPaymentType(paymentType);

        String[] items = transaction.getItems().split(",");
        List<ItemResponse> itemResponses = new ArrayList<>();

        for(String item : items){
            ItemResponse itemById = itemGateway.findItemById(Integer.parseInt(item));
            itemResponses.add(itemById);
        }
        transactionResponse.setItemList(itemResponses);

        return transactionResponse;
    }

    private void validateRequestId(int transactionId) throws InvalidRequestException {
        if (transactionId < 0) {
            throw new InvalidRequestException("Id can't be lower than 0");
        }
    }

    private void setItemsCustomerAndPaymentTypeRequest(TransactionRequest request) throws NotFoundException, InvalidRequestException {
        PaymentTypeResponse paymentTypeCode = paymentTypeGateway.findPaymentTypeByPaymentTypeCode(request.getPaymentTypeCode());
        request.setPaymentTypeCode(paymentTypeCode.getPaymentTypeCode());

        CustomerResponse customer = customerGateway.findCustomerById(request.getCustomerId());
        request.setCustomerId(customer.getCustomerId());

        String[] items = request.getItems().split(",");
        List<String> itemRequest = new ArrayList<>();

        for(String item : items){
            ItemResponse itemResponse = itemGateway.findItemById(Integer.valueOf(item));
            itemRequest.add(String.valueOf(itemResponse.getItemId()));
        }
        request.setItems(String.join(",", itemRequest));
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
