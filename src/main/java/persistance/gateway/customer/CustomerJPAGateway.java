package persistance.gateway.customer;

import org.springframework.beans.factory.annotation.Autowired;
import persistance.entity.Customer;
import persistance.repository.CustomerRepository;

import java.util.List;

public class CustomerJPAGateway implements CustomerGateway {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findCustomerById(int customerId) {
        return repository.findById(customerId).get();
    }

    @Override
    public void createCustomer(Customer customer) {
        repository.save(customer);
    }
}
