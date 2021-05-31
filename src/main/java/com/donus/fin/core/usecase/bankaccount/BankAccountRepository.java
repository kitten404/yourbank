package com.donus.fin.core.usecase.bankaccount;

import com.donus.fin.core.domain.BankAccount;

public interface BankAccountRepository {
	
	BankAccount create(BankAccount bankAccount);
	
	BankAccount FindByField(Integer id);
}
