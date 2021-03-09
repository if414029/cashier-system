package persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistance.entity.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, String> {
}
