package service.entity;

import lombok.Getter;
import lombok.Setter;
import persistance.entity.Customer;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class TransactionResponse extends ServiceResponse {
    private List<ItemResponse> items;
    private Customer customer;
    private String purchaseDate;
    private String description;
    private double totalPrice;
}
