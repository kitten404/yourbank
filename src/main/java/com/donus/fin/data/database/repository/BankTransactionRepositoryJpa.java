package com.donus.fin.data.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.donus.fin.data.database.entity.BankTransactionData;

@Repository
public interface BankTransactionRepositoryJpa extends JpaRepository<BankTransactionData, Integer> {
	@Query(value = "SELECT * FROM TRANSFER_ORDER WHERE ID_CUSTOMER = :id"
			, nativeQuery = true)
	List<BankTransactionData> getTransactionByAccount(Integer id);
}
