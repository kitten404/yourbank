package com.donus.fin.core.usecase.account;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.Account;

public class CreateAccountUseCase {
	
	@Autowired
	private AccountRepository repository;
	
	public Account execute(Long agencia) {
		Account account = this.gerarConta(agencia);
		return repository.create(account);
	}
	
	public Account gerarConta(Long agencia) {
		Long conta = null;
		conta = (repository.findLastAccount(agencia) + 1);
		return new Account
				(null,
				conta,
				agencia,
				"X"
				);
	}

}
