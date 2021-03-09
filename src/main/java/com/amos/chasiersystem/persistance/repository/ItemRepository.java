package com.amos.chasiersystem.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amos.chasiersystem.persistance.entity.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update Item it set it.stock = :stock where it.itemId = :itemId")
    void updateItemEntity(@Param(value = "itemId") int itemId, @Param(value = "stock") int stock);
}
