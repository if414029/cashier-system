package persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistance.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
