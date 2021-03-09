package controller;

import common.InvalidRequestException;
import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.entity.*;
import service.item.Item;
import service.paymentType.PaymentType;

@RestController
@RequestMapping("/api/v1/paymentTypes")
public class PaymentTypeController {
    @Autowired
    private PaymentType paymentType;

    @GetMapping(path = "/")
    private ResponseEntity<Object> findAll() {
        PaymentTypeListResponse response =  paymentType.findAll();

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{paymentTypeCode}")
    public ResponseEntity<Object> findPaymentTypeByPaymentTypeCode(@PathVariable String paymentTypeCode) throws NotFoundException, InvalidRequestException {
        PaymentTypeResponse response = paymentType.findPaymentTypeByPaymentTypeCode(paymentTypeCode);

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createPaymentType(@RequestBody PaymentTypeRequest request) throws InvalidRequestException, NotFoundException {
        ServiceResponse response = new ServiceResponse();

        paymentType.createPaymentType(request);

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
