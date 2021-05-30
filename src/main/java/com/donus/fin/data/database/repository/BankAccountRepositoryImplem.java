package com.donus.fin.data.database.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.usecase.bankaccount.BankAccountRepository;
import com.donus.fin.data.database.entity.BankAccountData;

public class BankAccountRepositoryImplem implements BankAccountRepository{

	@Autowired
	private BankAccountRepositoryJpa repository;
	
	@Override
	public BankAccount create(BankAccount bankAccount) {
		BankAccountData bankAccountData = 
				BankAccountData.convert(bankAccount);
		return repository.save(bankAccountData).convert();
	}

}
