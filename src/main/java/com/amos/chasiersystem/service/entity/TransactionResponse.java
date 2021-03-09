package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionResponse extends ServiceResponse {
    private int transactionId;
    private String items;
    private int customerId;
    private String paymentTypeCode;
    private List<ItemResponse> itemList;
    private CustomerResponse customer;
    private String purchaseDate;
    private String description;
    private double totalPrice;
    private PaymentTypeResponse paymentType;
}
