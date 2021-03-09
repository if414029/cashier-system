package com.amos.chasiersystem.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amos.chasiersystem.persistance.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
