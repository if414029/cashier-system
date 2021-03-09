package com.amos.chasiersystem.service.customer;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import org.springframework.stereotype.Service;
import com.amos.chasiersystem.persistance.gateway.customer.CustomerGateway;
import com.amos.chasiersystem.service.entity.CustomerListResponse;
import com.amos.chasiersystem.service.entity.CustomerRequest;
import com.amos.chasiersystem.service.entity.CustomerResponse;

@Service
public class CustomerService implements Customer {

    private final CustomerGateway gateway;

    public CustomerService(CustomerGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CustomerListResponse findAll() {
        return gateway.findAll();
    }

    @Override
    public CustomerResponse findCustomerById(int customerId) throws NotFoundException, InvalidRequestException {
        validateRequestId(customerId);
        return gateway.findCustomerById(customerId);
    }

    @Override
    public void createCustomer(CustomerRequest customer) throws InvalidRequestException {
        validateRequest(customer);
        gateway.createCustomer(customer);

    }

    private void validateRequestId(int customerId) throws InvalidRequestException {
        if (customerId < 0) {
            throw new InvalidRequestException("Id can't be lower than 0");
        }
    }

    private void validateRequest(CustomerRequest request) throws InvalidRequestException {
        if (request == null) {
            throw new InvalidRequestException("Request can't be null!");
        }

        if (request.getCustomerName() == null) {
            throw new InvalidRequestException("Customer can't be null!");
        }

        if (request.getAddress() == null) {
            throw new InvalidRequestException("Address can't be null!");
        }

        if (request.getGender() == null) {
            throw new InvalidRequestException("Gender can't be null!");
        }

        if (request.getPhoneNo() == null) {
            throw new InvalidRequestException("Phone No can't be null!");
        }

    }
}
