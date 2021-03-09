package com.amos.chasiersystem.controller;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.amos.chasiersystem.service.entity.ServiceResponse;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex){
        ServiceResponse response = new ServiceResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setStatusMessage(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex){
        ServiceResponse response = new ServiceResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setStatusMessage(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
