package com.amos.chasiersystem.controller;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amos.chasiersystem.service.entity.*;
import com.amos.chasiersystem.service.transaction.Transaction;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    private Transaction transaction;

    @GetMapping(path = "/")
    private ResponseEntity<Object> findAll() throws NotFoundException, InvalidRequestException {
        TransactionListResponse response =  transaction.findAll();

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{transactionId}")
    public ResponseEntity<Object> findItemById(@PathVariable int transactionId) throws NotFoundException, InvalidRequestException {
        TransactionResponse response = transaction.findTransactionById(transactionId);

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createTransaction(@RequestBody TransactionDataRequest request) throws InvalidRequestException, NotFoundException, JsonProcessingException {
        ServiceResponse response = new ServiceResponse();

        transaction.createTransaction(request);


        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

}
