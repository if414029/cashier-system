package service.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaymentTypeListResponse extends ServiceResponse {
    private List<PaymentTypeResponse> listPaymentType;
}
