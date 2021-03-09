package com.amos.chasiersystem.service.paymentType;

import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.stereotype.Service;
import com.amos.chasiersystem.persistance.gateway.paymentType.PaymentTypeGateway;
import com.amos.chasiersystem.service.entity.PaymentTypeListResponse;
import com.amos.chasiersystem.service.entity.PaymentTypeRequest;
import com.amos.chasiersystem.service.entity.PaymentTypeResponse;

@Service
public class PaymentTypeService implements PaymentType{

    private final PaymentTypeGateway gateway;

    public PaymentTypeService(PaymentTypeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PaymentTypeListResponse findAll() {
        return gateway.findAll();
    }

    @Override
    public PaymentTypeResponse findPaymentTypeByPaymentTypeCode(String paymentTypeCode) throws NotFoundException {
        return gateway.findPaymentTypeByPaymentTypeCode(paymentTypeCode);
    }

    @Override
    public void createPaymentType(PaymentTypeRequest request) {
        gateway.createPaymentType(request);
    }
}
