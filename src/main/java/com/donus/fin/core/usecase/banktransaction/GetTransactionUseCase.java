package com.donus.fin.core.usecase.banktransaction;

import java.util.List;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.usecase.account.FindAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.FindBankAccountUseCase;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetTransactionUseCase {
	
	private BankTransactionRepository repository;
	
	private FindAccountUseCase accountUseCase;
	
	private FindBankAccountUseCase findBankAccountUseCase;
	
	public List<BankTransactionResponse> getTransactionByAccount(Long agencia, Long conta) {
		Account account = accountUseCase.execute(agencia, conta);
		BankAccount bAccount = findBankAccountUseCase.execute(account.getId());
		return BankTransactionResponse.convertToList
				(repository.getTransactionUseCaseByAccount(bAccount.getCustomer().getId()));
	}

}
