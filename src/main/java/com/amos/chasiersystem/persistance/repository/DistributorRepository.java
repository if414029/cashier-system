package com.amos.chasiersystem.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amos.chasiersystem.persistance.entity.Distributor;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
}
