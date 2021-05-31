package com.donus.fin.core.usecase.account;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.Account;

public class FindAccountUseCase {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public Account execute(Long agencia, Long conta) {
		return accountRepository.findByFields(agencia, conta);
	}

}
