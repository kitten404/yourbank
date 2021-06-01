package com.donus.fin.data.database.repository;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.data.database.entity.AccountData;

@SpringBootTest
public class AccountRepositoryImplemTest {
	
	@Mock
	private AccountRepositoryJpa repository;
	@InjectMocks
	private AccountRepositoryImplem accountRepositoryImplem;
	
	@Test
	public void createOk() {
		
		Mockito.when(repository.save(createAccountData()))
		.thenReturn(accountReturn());
		
		Account account =
				accountRepositoryImplem.create(createAccount());
		
		Assert.assertNotNull(account);
		
	}
	
	@Test
	public void findLastAccountOk() {
		Mockito.when(repository.getLastCreatedAccount((long)123))
		.thenReturn((long)9090);
		
		Long conta =
				accountRepositoryImplem.findLastAccount((long)123);
		
		Assert.assertNotNull(conta);
	}
	
	@Test
	public void findByFieldsOk() {
		Mockito.when(repository.findByFields((long)123,(long)123))
		.thenReturn(accountReturn());
		
		Account account =
				accountRepositoryImplem.findByFields((long)123,(long)123);
		
		Assert.assertNotNull(account);
	}
	
	@Test
	public void findLastAccountNOk() {
		Mockito.when(repository.getLastCreatedAccount((long)123))
		.thenReturn(null);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			accountRepositoryImplem.findLastAccount((long)123);
		 });
		
	}
	
	@Test
	public void findByFieldsNOk() {
		Mockito.when(repository.findByFields((long)123,(long) 123))
		.thenReturn(null);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			accountRepositoryImplem.findByFields((long)123,(long) 123);
		 });
		
	}
	
	private AccountData createAccountData() {
		return new AccountData(null,(long)123,(long)123,"");
	}
	
	private Account createAccount() {
		return new Account(null,(long)123,(long)123,"");
	}
	
	private AccountData accountReturn() {
		return new AccountData(1,(long)123,(long)123,"");
	}

}
