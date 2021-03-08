package service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    private String items;
    private int customerId;
    private String purchaseDate;
    private String description;
    private double totalPrice;
    private String paymentTypeCode;
}
