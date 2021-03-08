package persistance.gateway.customer;

import javassist.NotFoundException;
import persistance.entity.Customer;
import service.entity.CustomerListResponse;
import service.entity.CustomerRequest;
import service.entity.CustomerResponse;

import java.util.List;

public interface CustomerGateway {

    CustomerListResponse findAll();

    CustomerResponse findCustomerById(int customerId) throws NotFoundException, common.NotFoundException;

    void createCustomer(CustomerRequest customer);

}
