package com.donus.fin.core.usecase.account;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Account;

@SpringBootTest
public class FindAccountUseCaseTest {
	
	@Mock
	private AccountRepository repository;
	
	@InjectMocks
	private FindAccountUseCase findAccountUseCase;
	
	@Test
	public void executeOk() {
		
		Mockito.when(repository.findByFields((long)1, (long) 1))
				.thenReturn(new Account(1,(long)1,(long)1,"X"));
		
		Account account = findAccountUseCase.execute((long)1, (long)1);
		
		Assert.assertEquals(account.getDigito(),"X");
		
	}

}
