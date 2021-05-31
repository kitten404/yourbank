package com.donus.fin.data.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.donus.fin.data.database.entity.AccountData;

public interface AccountRepositoryJpa extends JpaRepository<AccountData, Long>{
	
	@Query(value = "SELECT ISNULL( "
			+ "(SELECT top 1 conta FROM ACCOUNT "
					+ "WHERE agencia = :agencia order by conta desc), 0)", nativeQuery = true)
	Long getLastCreatedAccount(Long agencia);
	
	@Query(value = "SELECT * FROM ACCOUNT WHERE AGENCIA = :agencia AND CONTA = :conta", nativeQuery = true)
	AccountData findByFields(Long agencia, Long conta);


}
