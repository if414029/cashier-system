package com.amos.chasiersystem.service.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentTypeResponse extends ServiceResponse {
    private String paymentTypeCode;
    private String paymentTypeName;
}
