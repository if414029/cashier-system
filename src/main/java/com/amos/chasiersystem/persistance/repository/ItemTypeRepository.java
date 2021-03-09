package com.amos.chasiersystem.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amos.chasiersystem.persistance.entity.ItemType;

public interface ItemTypeRepository extends JpaRepository<ItemType, String> {
}
