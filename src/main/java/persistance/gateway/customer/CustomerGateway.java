package persistance.gateway.customer;

import common.NotFoundException;
import service.entity.CustomerListResponse;
import service.entity.CustomerRequest;
import service.entity.CustomerResponse;

public interface CustomerGateway {

    CustomerListResponse findAll();

    CustomerResponse findCustomerById(int customerId) throws NotFoundException;

    void createCustomer(CustomerRequest customer);

}
