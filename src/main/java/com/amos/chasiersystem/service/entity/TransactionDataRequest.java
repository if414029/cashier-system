package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDataRequest {
    private String items;
    private int customerId;
    private String purchaseDate;
    private String description;
    private String paymentTypeCode;
}
