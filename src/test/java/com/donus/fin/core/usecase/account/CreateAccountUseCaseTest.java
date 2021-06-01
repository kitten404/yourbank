package com.donus.fin.core.usecase.account;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Account;

@SpringBootTest
public class CreateAccountUseCaseTest {
	
	@Mock
	private AccountRepository repository;
	
	@InjectMocks
	private CreateAccountUseCase createAccountUseCase;
	
	@Test
	public void executeOK() {
		
		Mockito.when(repository.findLastAccount((long) 123)).thenReturn((long)1);
		Mockito.when(repository.create(account())).thenReturn(accountReturn());
		
		Account account =
				createAccountUseCase.execute((long)123);
		
		Assert.assertEquals(account.getConta(),accountReturn().getConta());
	}
	
	private Account account() {
		return Account.builder()
				.id(null)
				.conta((long)2)
				.agencia((long)123)
				.digito("X")
				.build();
	}
	
	private Account accountReturn() {
		return Account.builder()
				.id(null)
				.conta((long)2)
				.agencia((long)123)
				.digito("X")
				.build();
	}

}
