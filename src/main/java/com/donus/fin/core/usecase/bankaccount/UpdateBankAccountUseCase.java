package com.donus.fin.core.usecase.bankaccount;

import com.donus.fin.core.domain.BankAccount;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateBankAccountUseCase {
	
	private BankAccountRepository repository;
	
	public BankAccount execute(BankAccount bankAccount) {
		return repository.create(bankAccount);
	}

}
