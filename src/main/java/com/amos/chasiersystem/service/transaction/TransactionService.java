package com.amos.chasiersystem.service.transaction;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amos.chasiersystem.persistance.gateway.customer.CustomerGateway;
import com.amos.chasiersystem.persistance.gateway.item.ItemGateway;
import com.amos.chasiersystem.persistance.gateway.paymentType.PaymentTypeGateway;
import com.amos.chasiersystem.persistance.gateway.transaction.TransactionGateway;
import com.amos.chasiersystem.service.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void createTransaction(TransactionDataRequest requestData) throws InvalidRequestException, NotFoundException, JsonProcessingException {
        validateRequest(requestData);
        TransactionRequest request = setItemsCustomerAndPaymentTypeRequest(requestData);
        gateway.createTransaction(request);
    }

    private TransactionListResponse constructTransactionListResponse(TransactionListResponse transactionListResponse) throws NotFoundException, InvalidRequestException {
        TransactionListResponse response = new TransactionListResponse();

        List<TransactionResponse> transactionResponses = new ArrayList<>();
        for(TransactionResponse transactionResponse : transactionListResponse.getListTransaction()){
            transactionResponses.add(constructTransactionResponse(transactionResponse));
        }
        response.setListTransaction(transactionResponses);

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

    private TransactionRequest setItemsCustomerAndPaymentTypeRequest(TransactionDataRequest requestData) throws NotFoundException, InvalidRequestException, JsonProcessingException {
        TransactionRequest request = new TransactionRequest();
        request.setDescription(requestData.getDescription());
        request.setPurchaseDate(requestData.getPurchaseDate());

        PaymentTypeResponse paymentTypeCode = paymentTypeGateway.findPaymentTypeByPaymentTypeCode(requestData.getPaymentTypeCode());
        request.setPaymentTypeCode(paymentTypeCode.getPaymentTypeCode());

        CustomerResponse customer = customerGateway.findCustomerById(requestData.getCustomerId());
        request.setCustomerId(customer.getCustomerId());

        ObjectMapper mapper = new ObjectMapper();
        List<ItemDataRequest> items = Arrays.asList(mapper.readValue(requestData.getItems(), ItemDataRequest[].class));
        List<String> itemRequest = new ArrayList<>();

        double totalPrice = 0;
        for(ItemDataRequest item : items){
            ItemResponse itemResponse = itemGateway.findItemById(Integer.valueOf(item.getItemId()));
            totalPrice += itemResponse.getPrice() * item.getTotal();
            int stock = itemResponse.getStock()-item.getTotal();
            itemGateway.updateItem(itemResponse.getItemId(), stock);
            itemRequest.add(String.valueOf(itemResponse.getItemId()));
        }

        request.setTotalPrice(totalPrice);
        request.setItems(String.join(",", itemRequest));

        return request;
    }


    private void validateRequest(TransactionDataRequest request) throws InvalidRequestException {
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
