package service.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PaymentTypeResponse extends ServiceResponse {
    private String paymentTypeCode;
    private String paymentTypeName;
}
