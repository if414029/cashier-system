package com.amos.chasiersystem.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amos.chasiersystem.persistance.entity.Item;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update Item it set it.stock = :stock where it.itemId = :itemId")
    void updateItemEntity(@Param(value = "itemId") int itemId, @Param(value = "stock") int stock);


    @Query(value = "select * from item it where it.item_name = :itemName", nativeQuery = true)
    List<Item> getItemByItemName(String itemName);

    @Query(value = "select * from item it inner join distributor dt ON it.distributor_id = dt.distributor_id where dt.distributor_name = :distributorName", nativeQuery = true)
    List<Item> getItemByDistributorName(String distributorName);
}
