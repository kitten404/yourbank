package com.donus.fin.data.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.usecase.account.AccountRepository;
import com.donus.fin.data.database.entity.AccountData;

@Repository
public class AccountRepositoryImplem implements AccountRepository{
	
	@Autowired
	private AccountRepositoryJpa repository;

	@Override
	public Account create(Account account) {
		AccountData accountData = AccountData.convert(account);
		return repository.save(accountData).convert();
	}

	@Override
	public Long findLastAccount(Long agencia) {
		return repository.getLastCreatedAccount(agencia);
	}

	@Override
	public Account findByFields(Long agencia, Long conta) {
		return repository.findByFields(agencia, conta).convert();
	}

}
