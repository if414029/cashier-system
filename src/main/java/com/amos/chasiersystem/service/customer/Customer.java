package com.amos.chasiersystem.service.customer;

import com.amos.chasiersystem.common.InvalidRequestException;
import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.CustomerListResponse;
import com.amos.chasiersystem.service.entity.CustomerRequest;
import com.amos.chasiersystem.service.entity.CustomerResponse;

public interface Customer {
    CustomerListResponse findAll();

    CustomerResponse findCustomerById(int customerId) throws InvalidRequestException, NotFoundException;

    void createCustomer(CustomerRequest customer) throws InvalidRequestException;
}
