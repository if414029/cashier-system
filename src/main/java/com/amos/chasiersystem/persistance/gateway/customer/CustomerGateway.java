package com.amos.chasiersystem.persistance.gateway.customer;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.service.entity.CustomerListResponse;
import com.amos.chasiersystem.service.entity.CustomerRequest;
import com.amos.chasiersystem.service.entity.CustomerResponse;

public interface CustomerGateway {

    CustomerListResponse findAll();

    CustomerResponse findCustomerById(int customerId) throws NotFoundException;

    void createCustomer(CustomerRequest customer);

}
