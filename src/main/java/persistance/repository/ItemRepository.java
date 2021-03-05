package persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistance.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
