package persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistance.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
