package service.customer;

import common.InvalidRequestException;
import common.NotFoundException;
import service.entity.CustomerListResponse;
import service.entity.CustomerRequest;
import service.entity.CustomerResponse;

public interface Customer {
    CustomerListResponse findAll();

    CustomerResponse findCustomerById(int customerId) throws InvalidRequestException, NotFoundException;

    void createCustomer(CustomerRequest customer) throws InvalidRequestException;
}
