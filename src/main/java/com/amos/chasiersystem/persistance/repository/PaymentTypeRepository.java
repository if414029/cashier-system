package com.amos.chasiersystem.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amos.chasiersystem.persistance.entity.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, String> {
}
