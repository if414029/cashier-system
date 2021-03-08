package persistance.gateway.customer;

import common.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import persistance.entity.Customer;
import persistance.repository.CustomerRepository;
import service.entity.CustomerListResponse;
import service.entity.CustomerRequest;
import service.entity.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

public class CustomerJPAGateway implements CustomerGateway {

    @Autowired
    private CustomerRepository repository;

    @Override
    public CustomerListResponse findAll() {
        List<Customer> customerList = repository.findAll();
        return constructCustomerListResponse(customerList);
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

    @Override
    public CustomerResponse findCustomerById(int customerId) throws NotFoundException {
        return repository.findById(customerId)
                .map(this::constructCustomerResponse)
                .orElseThrow(() -> new NotFoundException("Data Not Found with id : " + customerId));
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

    @Override
    public void createCustomer(CustomerRequest request) {
        Customer entity = getCustomerEntity(request);

        repository.save(entity);
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
