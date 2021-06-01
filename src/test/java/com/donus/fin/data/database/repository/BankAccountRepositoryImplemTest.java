package com.donus.fin.data.database.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.data.database.entity.AccountData;
import com.donus.fin.data.database.entity.BankAccountData;
import com.donus.fin.data.database.entity.CustomerData;

@SpringBootTest
public class BankAccountRepositoryImplemTest {
	
	@Mock
	private BankAccountRepositoryJpa repository;
	@InjectMocks
	private BankAccountRepositoryImplem bankAccountRepositoryImplem;
	
	@Test
	public void createOK() {
		BankAccountData bk = bankAccountCreate();
		bk.setId(1);
		
		Mockito.when(repository.save(bankAccountCreate()))
			.thenReturn(bk);
		
		BankAccount bkA = 
				bankAccountRepositoryImplem.create(bankAccount2Create());
		
		Assert.assertNotNull(bkA);
				
	}
	
	@Test
	public void findByFieldOk() {
		BankAccountData bk = bankAccountCreate();
		bk.setId(1);
		
		Mockito.when(repository.findByField(2))
			.thenReturn(bankAccountCreate());
		
		BankAccount bkA = 
				bankAccountRepositoryImplem.FindByField(2);
		
		
		Assert.assertNotNull(bkA);
	}
	
	@Test
	public void findByFieldNOk() {
		Mockito.when(repository.findByField(2))
			.thenReturn(null);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			bankAccountRepositoryImplem.FindByField(2);
		 });
	}
	
	private BankAccountData bankAccountCreate() {
		return new BankAccountData(null, createCustomer(),createAccount(),300.90);
	}
	
	private BankAccount bankAccount2Create() {
		return new BankAccount(null,300.90,new Account(1,(long)123,(long)123,"X"),new Customer(1, "12325232523","Teste Teste"));
	}
	
	private CustomerData createCustomer() {
		return new CustomerData(1, "12325232523","Teste Teste");
	}
	
	private AccountData createAccount() {
		return new AccountData(1,(long)123,(long)123,"X");
	}

}
