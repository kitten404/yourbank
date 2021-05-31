package com.donus.fin.core.usecase.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.BankAccount;

public class FindBankAccountUseCase {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	public BankAccount execute(Integer id) {
		return bankAccountRepository.FindByField(id);
	}

}
