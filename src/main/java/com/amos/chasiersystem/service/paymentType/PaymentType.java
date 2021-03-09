package com.amos.chasiersystem.service.paymentType;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.*;

public interface PaymentType {
    PaymentTypeListResponse findAll();

    PaymentTypeResponse findPaymentTypeByPaymentTypeCode(String paymentTypeCode) throws NotFoundException;

    void createPaymentType(PaymentTypeRequest request);
}
