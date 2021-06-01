package com.donus.fin.data.database.repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.BankTransaction;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.data.database.entity.AccountData;
import com.donus.fin.data.database.entity.BankAccountData;
import com.donus.fin.data.database.entity.BankTransactionData;
import com.donus.fin.data.database.entity.CustomerData;
import com.donus.fin.data.database.entity.TransactionTypeData;

@SpringBootTest
public class BankTransactionRepositoryImplemTest {
	
	@Mock
	private BankTransactionRepositoryJpa repository;
	
	@InjectMocks
	private BankTransactionRepositoryImplem bankTransactionRepositoryImplem;
	
	@Test
	public void createBankTransaction() {
				
		Mockito.when(repository.save(createAccountData()))
			.thenReturn(createAccountDataReturn());
				
		BankTransaction bkT =
				bankTransactionRepositoryImplem.createBankTransaction(createAccountData().convert());
		
		Assert.assertEquals(bkT.getReceiver().getCustomer().getCpf(), "45623562362");
	}
	
	@Test
	public void getTransactionUseCaseByAccountOK() {
		
		Mockito.when(repository.getTransactionByAccount(1))
			.thenReturn(Arrays.asList(createAccountData()));
		
		List<BankTransaction> bkTList =
				bankTransactionRepositoryImplem.getTransactionUseCaseByAccount(1);
		
		Assert.assertEquals(bkTList.size(), 1);
	}
	
	@Test
	public void getTransactionUseCaseByAccountNOK() {
		
		Mockito.when(repository.getTransactionByAccount(1))
			.thenReturn(null);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			bankTransactionRepositoryImplem.getTransactionUseCaseByAccount(1);
		 });
	}
	
	private BankTransactionData createAccountData() {
		return new BankTransactionData
				(null, createCustomerData(),LocalDateTime.of(2015, 
                        Month.JULY, 29, 19, 30, 40), 
						200.00, new TransactionTypeData(1, "X", "X"), bankAccountData());
	}
	
	private BankTransactionData createAccountDataReturn() {
		return new BankTransactionData
				(1, createCustomerData(),LocalDateTime.of(2015, 
                        Month.JULY, 29, 19, 30, 40), 
						200.00, new TransactionTypeData(1, "X", "X"), bankAccountData());
	}
	
	private BankAccountData bankAccountData() {
		return new BankAccountData(1,createCustomerRecepData(),accountData(),200.00);
	}
	
	private AccountData accountData() {
		return new AccountData(1,(long)232,(long)2333,"X");
	}
	
	private CustomerData createCustomerRecepData() {
		return new CustomerData(2, "45623562362","Teste Teste");
	}

	
	private CustomerData createCustomerData() {
		return new CustomerData(1, "12325232523","Teste Teste");
	}

}
