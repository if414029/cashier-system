package persistance.gateway.paymentType;

import persistance.entity.PaymentType;

import java.util.List;

public interface PaymentTypeGateway {
    List<PaymentType> findAll();

    PaymentType findPaymentTypeByCode(String paymentTypeCode);

    void createPaymentType(PaymentType paymentType);
}
