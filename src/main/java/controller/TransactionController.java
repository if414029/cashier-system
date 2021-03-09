package controller;

import common.InvalidRequestException;
import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.entity.*;
import service.transaction.Transaction;

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
    public ResponseEntity<Object> createTransaction(@RequestBody TransactionRequest request) throws InvalidRequestException, NotFoundException {
        ServiceResponse response = new ServiceResponse();

        transaction.createTransaction(request);

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

}
