package com.donus.fin.core.usecase.bankaccount;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.usecase.account.CreateAccountUseCase;
import com.donus.fin.core.usecase.customer.CreateCustomerUseCase;
import com.donus.fin.presenter.http.request.CreateBankAccountRequest;
import com.donus.fin.presenter.http.response.BankAccountResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateBankAccountUseCase {
	
	private BankAccountRepository bankAccountRepository;
	private CreateAccountUseCase createAccountUseCase;
	private CreateCustomerUseCase createCustomerUseCase;
	
	public BankAccountResponse execute(CreateBankAccountRequest request) {
		Customer customer =
				createCustomerUseCase.execute(request);
		
		Account account = 
				createAccountUseCase.execute(request.getAgencia());
		
		BankAccount bankAccountCreate = 
				new BankAccount(null, 10.0, account, customer);
		
		BankAccount bankAccount =
				bankAccountRepository.create(bankAccountCreate);
		
		return BankAccountResponse.response(bankAccount);
	}

}
