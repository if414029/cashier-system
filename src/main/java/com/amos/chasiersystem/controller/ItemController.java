package com.amos.chasiersystem.controller;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.amos.chasiersystem.service.entity.*;
import com.amos.chasiersystem.service.item.Item;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private Item item;

    @GetMapping(path = "/")
    private ResponseEntity<Object> findAllListCustomer() {
        ItemListResponse response =  item.findAll();

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{itemId}")
    public ResponseEntity<Object> findItemById(@PathVariable int itemId) throws NotFoundException, InvalidRequestException {
        ItemResponse response = item.findItemById(itemId);

        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage(HttpStatus.OK.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<Object> createCustomer(@RequestBody ItemRequest request) throws InvalidRequestException, NotFoundException {
        ServiceResponse response = new ServiceResponse();

        item.createItem(request);

        response.setStatusCode(HttpStatus.CREATED.value());
        response.setStatusMessage(HttpStatus.CREATED.getReasonPhrase());

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

}
