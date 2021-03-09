package com.amos.chasiersystem.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class PaymentType {

    @Id
    private String paymentTypeCode;

    @Column
    private String paymentTypeName;

}
