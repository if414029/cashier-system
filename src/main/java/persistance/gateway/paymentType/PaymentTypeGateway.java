package persistance.gateway.paymentType;

import common.NotFoundException;
import persistance.entity.PaymentType;
import service.entity.PaymentTypeListResponse;
import service.entity.PaymentTypeRequest;
import service.entity.PaymentTypeResponse;

import java.util.List;

public interface PaymentTypeGateway {
    PaymentTypeListResponse findAll();

    PaymentTypeResponse findPaymentTypeByPaymentTypeCode(String paymentTypeCode) throws NotFoundException;

    void createPaymentType(PaymentTypeRequest request);
}
