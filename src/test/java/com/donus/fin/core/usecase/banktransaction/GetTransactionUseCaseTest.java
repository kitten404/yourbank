package com.donus.fin.core.usecase.banktransaction;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.BankTransaction;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.account.FindAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.FindBankAccountUseCase;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@SpringBootTest
public class GetTransactionUseCaseTest {
	
	@Mock
	private BankTransactionRepository repository;
	@Mock
	private FindAccountUseCase accountUseCase;
	@Mock
	private FindBankAccountUseCase findBankAccountUseCase;
	@InjectMocks
	private GetTransactionUseCase getTransactionUseCase;
	
	@Test
	public void executeOk(){
		
		Mockito.when(accountUseCase.execute((long)123, (long)123))
			.thenReturn(createAccount());
		
		Mockito.when(findBankAccountUseCase.execute(1))
			.thenReturn(bankAccountReturn());
		
		Mockito.when(repository.getTransactionUseCaseByAccount(1))
			.thenReturn(listTransactions());
		
		List<BankTransactionResponse> list =
				getTransactionUseCase.getTransactionByAccount((long)123, (long)123);
		
		Assert.assertNotNull(list);
	}
	
	private Account createAccount() {
		return new Account(1,(long)123,(long)123,"");
	}
	
	private BankAccount bankAccountReturn() {
		return new BankAccount(1,10.0,createAccount(),createCustomer());
	}
	
	private Customer createCustomer() {
		return new Customer(1, "12325232523","Teste Teste");
	}
	
	private List<BankTransaction> listTransactions(){
		BankTransaction bt = 
				new BankTransaction(1, LocalDateTime.now(), 200.00, new TransactionType(1, "X", "X"), createCustomer(), bankAccountReturn());
		return Arrays.asList(bt);
	}

}
