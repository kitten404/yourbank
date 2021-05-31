package com.donus.fin.presenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.donus.fin.core.usecase.account.CreateAccountUseCase;
import com.donus.fin.core.usecase.account.FindAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.BankAccountRepository;
import com.donus.fin.core.usecase.bankaccount.CreateBankAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.FindBankAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.UpdateBankAccountUseCase;
import com.donus.fin.core.usecase.banktransaction.BankTransactionRepository;
import com.donus.fin.core.usecase.banktransaction.CreateBankTransactionUseCase;
import com.donus.fin.core.usecase.customer.CreateCustomerUseCase;
import com.donus.fin.core.usecase.customer.FindCustomerUseCase;
import com.donus.fin.core.usecase.transactiontype.FindTransactionTypeUseCase;
import com.donus.fin.data.database.repository.BankAccountRepositoryImplem;
import com.donus.fin.data.database.repository.BankTransactionRepositoryImplem;

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
	
	@Bean 
	public CreateBankTransactionUseCase createBankTransactionUseCase(FindTransactionTypeUseCase findTransactionTypeUseCase,
			FindAccountUseCase findAccountUseCase, FindBankAccountUseCase findBankAccountUseCase, 
			UpdateBankAccountUseCase updateBankAccountUseCase, BankTransactionRepository bankTransactionRepository) {
		return new CreateBankTransactionUseCase(findTransactionTypeUseCase,findAccountUseCase,
				findBankAccountUseCase, updateBankAccountUseCase, bankTransactionRepository);
	}
	
	@Bean
	public FindTransactionTypeUseCase findTransactionTypeUseCase() {
		return new FindTransactionTypeUseCase();
	}
	
	@Bean
	public FindAccountUseCase findAccountUseCase() {
		return new FindAccountUseCase();
	}
	
	@Bean 
	public FindBankAccountUseCase findBankAccountUseCase() {
		return new FindBankAccountUseCase();
	}
	
	@Bean
	public FindCustomerUseCase findCustomerUseCase() {
		return new FindCustomerUseCase();
	}
	
	@Bean
	public UpdateBankAccountUseCase updateBankAccountUseCase(BankAccountRepository bankAccountRepository) {
		return new UpdateBankAccountUseCase(bankAccountRepository);
	}
	
	@Bean
	public BankTransactionRepository bankTransactionRepository() {
		return new BankTransactionRepositoryImplem();
	}

}
