package com.amos.chasiersystem.persistance.gateway.paymentType;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.persistance.entity.PaymentType;
import com.amos.chasiersystem.persistance.repository.PaymentTypeRepository;
import com.amos.chasiersystem.service.entity.PaymentTypeListResponse;
import com.amos.chasiersystem.service.entity.PaymentTypeRequest;
import com.amos.chasiersystem.service.entity.PaymentTypeResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentTypeJPAGateway implements PaymentTypeGateway{

    private final PaymentTypeRepository repository;

    public PaymentTypeJPAGateway(PaymentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentTypeListResponse findAll() {
        List<PaymentType> paymentTypeList = repository.findAll();
        return constructPaymentTypeListResponse(paymentTypeList);
    }

    @Override
    public PaymentTypeResponse findPaymentTypeByPaymentTypeCode(String paymentTypeCode) throws NotFoundException {
        return repository.findById(paymentTypeCode)
                .map(this::constructPaymentTypeResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + paymentTypeCode));
    }

    @Override
    public void createPaymentType(PaymentTypeRequest request) {
        PaymentType entity = getPaymentTypeEntity(request);
        repository.save(entity);
    }

    private PaymentType getPaymentTypeEntity(PaymentTypeRequest request) {
        PaymentType entity = new PaymentType();
        entity.setPaymentTypeCode(request.getPaymentTypeCode());
        entity.setPaymentTypeName(request.getPaymentTypeName());

        return entity;
    }

    private PaymentTypeListResponse constructPaymentTypeListResponse(List<PaymentType> paymentTypeList){
        PaymentTypeListResponse paymentTypeListResponse = new PaymentTypeListResponse();

        List<PaymentTypeResponse> paymentTypeResponses = new ArrayList<>();
        for(PaymentType paymentType : paymentTypeList){
            paymentTypeResponses.add(constructPaymentTypeResponse(paymentType));
        }

        paymentTypeListResponse.setListPaymentType(paymentTypeResponses);

        return paymentTypeListResponse;
    }

    private PaymentTypeResponse constructPaymentTypeResponse(PaymentType paymentType){
        PaymentTypeResponse response = new PaymentTypeResponse();
        response.setPaymentTypeCode(paymentType.getPaymentTypeCode());
        response.setPaymentTypeName(paymentType.getPaymentTypeName());

        return response;
    }
}
