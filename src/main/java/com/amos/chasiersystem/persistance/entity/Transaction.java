package com.amos.chasiersystem.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Column
    private String itemId;

    @Column
    private int customerId;

    @Column
    private Date purchaseDate;

    @Column
    private String description;

    @Column
    private double totalPrice;

    @Column
    private String paymentTypeCode;
}
