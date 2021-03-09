package service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionResponse extends ServiceResponse {
    private List<ItemResponse> items;
    private CustomerResponse customer;
    private String purchaseDate;
    private String description;
    private double totalPrice;
    private PaymentTypeResponse paymentType;
}
