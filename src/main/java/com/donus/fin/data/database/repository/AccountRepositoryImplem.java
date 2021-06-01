package com.donus.fin.data.database.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.usecase.account.AccountRepository;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
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
		return Optional.ofNullable(repository.getLastCreatedAccount(agencia))
				.orElseThrow(() -> {
					return new NotFoundException();
				});
	}

	@Override
	public Account findByFields(Long agencia, Long conta) {
		return Optional.ofNullable(repository.findByFields(agencia, conta))
		.orElseThrow(() ->{
			return new NotFoundException();
		}).convert();
	}

}
