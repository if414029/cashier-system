package persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistance.entity.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
}
