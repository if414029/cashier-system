package persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistance.entity.ItemType;

public interface ItemTypeRepository extends JpaRepository<ItemType, String> {
}
