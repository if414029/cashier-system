package service.paymentType;

import common.NotFoundException;
import service.entity.*;

public interface PaymentType {
    PaymentTypeListResponse findAll();

    PaymentTypeResponse findPaymentTypeByPaymentTypeCode(String paymentTypeCode) throws NotFoundException;

    void createPaymentType(PaymentTypeRequest request);
}
