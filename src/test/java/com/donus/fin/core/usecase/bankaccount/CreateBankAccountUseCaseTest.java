package com.donus.fin.core.usecase.bankaccount;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.usecase.account.CreateAccountUseCase;
import com.donus.fin.core.usecase.customer.CreateCustomerUseCase;
import com.donus.fin.presenter.http.request.CreateBankAccountRequest;
import com.donus.fin.presenter.http.response.BankAccountResponse;

@SpringBootTest
public class CreateBankAccountUseCaseTest {
	
	@Mock
	private BankAccountRepository repository;
	@Mock
	private CreateAccountUseCase createAccountUseCase;
	@Mock
	private CreateCustomerUseCase createCustomerUseCase;
	@InjectMocks
	private CreateBankAccountUseCase createBankAccountUseCase;
	
	@Test
	public void execute() {
		
		Mockito.when(createCustomerUseCase.execute(request()))
			.thenReturn(createCustomer());
		
		Mockito.when(createAccountUseCase.execute((long)9898))
			.thenReturn(createAccount());
		
		Mockito.when(repository.create(bankAccountCreate()))
			.thenReturn(bankAccountReturn());
		
		BankAccountResponse response = 
				createBankAccountUseCase.execute(request());
		
		Assert.assertEquals(response,response());
		
	}
	
	private Customer createCustomer() {
		return new Customer(1, "12325232523","Teste Teste");
	}
	
	private Account createAccount() {
		return new Account(1,(long)123,(long)123,"");
	}
	
	private BankAccount bankAccountCreate() {
		return new BankAccount(null,10.0,createAccount(),createCustomer());
	}
	
	private BankAccount bankAccountReturn() {
		return new BankAccount(1,10.0,createAccount(),createCustomer());
	}
	
	private CreateBankAccountRequest request() {
		CreateBankAccountRequest request = new CreateBankAccountRequest();
		request.setNome("Teste Teste");
		request.setAgencia((long)9898);
		request.setCpf("12325232523");
		return request;
	}
	
	private BankAccountResponse response() {
		return BankAccountResponse.response(bankAccountReturn());
	}
}
