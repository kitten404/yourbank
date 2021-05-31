package com.donus.fin.data.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.donus.fin.data.database.entity.BankAccountData;

public interface BankAccountRepositoryJpa extends JpaRepository<BankAccountData, Integer>{
	
	@Query(value = "SELECT * FROM BANK_ACCOUNT WHERE ID_ACCOUNT = :id",nativeQuery = true)
	BankAccountData findByField(Integer id);

}
