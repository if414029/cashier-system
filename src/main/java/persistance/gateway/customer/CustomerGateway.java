package persistance.gateway.customer;

import persistance.entity.Customer;

import java.util.List;

public interface CustomerGateway {

    List<Customer> findAll();

    Customer findCustomerById(int customerId);

    void createCustomer(Customer customer);

}
