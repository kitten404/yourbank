package com.donus.fin.core.usecase.banktransaction;

import java.util.List;

import com.donus.fin.core.domain.BankTransaction;

public interface BankTransactionRepository {
	
	BankTransaction createBankTransaction(BankTransaction bankTransaction);
	
	List<BankTransaction> getTransactionUseCaseByAccount(Integer id);

}
