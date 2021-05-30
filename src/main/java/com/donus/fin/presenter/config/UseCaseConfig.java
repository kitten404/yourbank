package com.donus.fin.presenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.donus.fin.core.usecase.account.CreateAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.BankAccountRepository;
import com.donus.fin.core.usecase.bankaccount.CreateBankAccountUseCase;
import com.donus.fin.core.usecase.customer.CreateCustomerUseCase;
import com.donus.fin.data.database.repository.BankAccountRepositoryImplem;

@Configuration
public class UseCaseConfig {
	
	@Bean
	public CreateBankAccountUseCase createBankAccountUseCase(BankAccountRepository repository,
			CreateAccountUseCase createAccountUseCase,
			CreateCustomerUseCase createCustomerUseCase) {
		return new CreateBankAccountUseCase(repository,createAccountUseCase,createCustomerUseCase);
	}
	
	@Bean 
	public BankAccountRepository bankAccountRepository() {
		return new BankAccountRepositoryImplem();
	}
	
	@Bean 
	public CreateCustomerUseCase createCustomerUseCase() {
		return new CreateCustomerUseCase();
	}
	
	@Bean
	public CreateAccountUseCase createAccountUseCase() {
		return new CreateAccountUseCase();
	}

}
