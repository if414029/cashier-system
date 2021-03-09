package com.amos.chasiersystem.controller;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amos.chasiersystem.service.customer.Customer;
import com.amos.chasiersystem.service.entity.CustomerListResponse;
import com.amos.chasiersystem.service.entity.CustomerRequest;
import com.amos.chasiersystem.service.entity.CustomerResponse;
import com.amos.chasiersystem.service.entity.ServiceResponse;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private Customer customer;

    @GetMapping(path = "/")
    private ResponseEntity<Object> findAll() {
        CustomerListResponse response =  customer.findAll();

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<Object> findCustomerById(@PathVariable int customerId) throws InvalidRequestException, NotFoundException {
        CustomerResponse response = customer.findCustomerById(customerId);

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerRequest request) throws InvalidRequestException {
        ServiceResponse response = new ServiceResponse();

        customer.createCustomer(request);

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}