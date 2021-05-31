package com.donus.fin.core.usecase.banktransaction;

import com.donus.fin.core.domain.BankTransaction;

public interface BankTransactionRepository {
	
	BankTransaction createBankTransaction(BankTransaction bankTransaction);

}
