package com.amos.chasiersystem.persistance.gateway.customer;

import com.amos.chasiersystem.common.NotFoundException;
import com.amos.chasiersystem.persistance.entity.Customer;
import com.amos.chasiersystem.persistance.repository.CustomerRepository;
import com.amos.chasiersystem.service.entity.CustomerListResponse;
import com.amos.chasiersystem.service.entity.CustomerRequest;
import com.amos.chasiersystem.service.entity.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

public class CustomerJPAGateway implements CustomerGateway {

    private final CustomerRepository repository;

    public CustomerJPAGateway(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerListResponse findAll() {
        List<Customer> customerList = repository.findAll();
        return constructCustomerListResponse(customerList);
    }

    @Override
    public CustomerResponse findCustomerById(int customerId) throws NotFoundException {
        return repository.findById(customerId)
                .map(this::constructCustomerResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + customerId));
    }

    @Override
    public void createCustomer(CustomerRequest request) {
        Customer entity = getCustomerEntity(request);

        repository.save(entity);
    }

    private CustomerResponse constructCustomerResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(customer.getCustomerId());
        response.setCustomerName(customer.getCustomerName());
        response.setAddress(customer.getAddress());
        response.setGender(customer.getGender());
        response.setPhoneNo(customer.getPhoneNo());

        return response;
    }

    private CustomerListResponse constructCustomerListResponse(List<Customer> customerList) {
        CustomerListResponse customerListResponse = new CustomerListResponse();

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customerList){

            customerResponses.add(constructCustomerResponse(customer));

        }
        customerListResponse.setListCustomer(customerResponses);

        return customerListResponse;
    }

    private Customer getCustomerEntity(CustomerRequest request) {

        Customer entity = new Customer();
        entity.setCustomerName(request.getCustomerName());
        entity.setAddress(request.getAddress());
        entity.setGender(request.getGender());
        entity.setPhoneNo(request.getPhoneNo());

        return entity;
    }
}
