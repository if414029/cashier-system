package com.amos.chasiersystem.controller;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amos.chasiersystem.service.distributor.Distributor;
import com.amos.chasiersystem.service.entity.*;

@RestController
@RequestMapping("/api/v1/distributors")
public class DistributorController {
    @Autowired
    private Distributor distributor;

    @GetMapping(path = "/")
    private ResponseEntity<Object> findAll() {
        DistributorListResponse response =  distributor.findAll();

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{distributorId}")
    public ResponseEntity<Object> findDistributorById(@PathVariable int distributorId) throws NotFoundException, InvalidRequestException {
        DistributorResponse response = distributor.findDistributorById(distributorId);

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createDistributor(@RequestBody DistributorRequest request) throws InvalidRequestException, NotFoundException {
        ServiceResponse response = new ServiceResponse();

        distributor.createDistributor(request);

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
}
