package com.donus.fin.presenter.http.entrypoint;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.usecase.bankaccount.CreateBankAccountUseCase;
import com.donus.fin.presenter.http.request.CreateBankAccountRequest;
import com.donus.fin.presenter.http.response.BankAccountResponse;

@SpringBootTest
public class BankAccountEntryPointTest {
	
	@MockBean
	private CreateBankAccountUseCase createBankAccountUseCase;
	
	@Test
	public void createAccountOK() {
		
		Mockito.when(createBankAccountUseCase.execute(createRequestOK()))
		.thenReturn(responseOK());
		
		BankAccountResponse bankAccountResponse = 
				createBankAccountUseCase.execute(createRequestOK());
		
		Assert.notNull(bankAccountResponse);
		
	}
	
	private CreateBankAccountRequest createRequestOK() {
		CreateBankAccountRequest request = new CreateBankAccountRequest();
		request.setAgencia((long)9399);
		request.setCpf("894494939383");
		request.setNome("Quezia Q");
		return request;
	}
	
	private BankAccountResponse responseOK() {
		Account account = new Account(1, (long)1, (long)9399, "X");
		Customer customer = new Customer(1, "894494939383", "Quezia Q");
		BankAccount bankAccount = new BankAccount(1, 0.0, account, customer);
		return BankAccountResponse.response(bankAccount);
	}

}
