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

@SpringBootTest
public class FindBankAccountUseCaseTest {
	
	@Mock
	private BankAccountRepository repository;
	
	@InjectMocks
	private FindBankAccountUseCase findBankAccountUseCase;
	
	@Test
	public void executeOk() {
		
		Mockito.when(repository.FindByField(1))
			.thenReturn(returnAccount());
		
		BankAccount bankAccount =
				findBankAccountUseCase.execute(1);
		
		Assert.assertEquals(bankAccount.getId(), returnAccount().getId());
		
	}
	
	private BankAccount returnAccount() {
		return new BankAccount
				(1, 290.00, new Account(1, null, null, null), new Customer());
	}
	

}
