package service.paymentType;

import common.NotFoundException;
import persistance.gateway.paymentType.PaymentTypeGateway;
import service.entity.PaymentTypeListResponse;
import service.entity.PaymentTypeRequest;
import service.entity.PaymentTypeResponse;

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
