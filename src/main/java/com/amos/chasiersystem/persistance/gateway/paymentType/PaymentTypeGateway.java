package com.amos.chasiersystem.persistance.gateway.paymentType;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.PaymentTypeListResponse;
import com.amos.chasiersystem.service.entity.PaymentTypeRequest;
import com.amos.chasiersystem.service.entity.PaymentTypeResponse;

public interface PaymentTypeGateway {
    PaymentTypeListResponse findAll();

    PaymentTypeResponse findPaymentTypeByPaymentTypeCode(String paymentTypeCode) throws NotFoundException;

    void createPaymentType(PaymentTypeRequest request);
}
