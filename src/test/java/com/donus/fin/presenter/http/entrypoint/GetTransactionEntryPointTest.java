package com.donus.fin.presenter.http.entrypoint;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.BankTransaction;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.banktransaction.GetTransactionUseCase;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@SpringBootTest
public class GetTransactionEntryPointTest {
	
	@Mock
	private GetTransactionUseCase getTransactionUseCase;
	
	@InjectMocks
	private GetTransactionEntryPoint getTransactionEntryPoint;
	
	@Test
	public void getTransactionEntryPoint() throws Exception {
		
		Mockito.when(getTransactionUseCase.getTransactionByAccount((long)123, (long)1234))
		.thenReturn(responseOK());
		
		ResponseEntity<?> response = 
				getTransactionEntryPoint.getTransactionByAccount((long)123, (long)1234);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	private List<BankTransactionResponse> responseOK() {
		List<BankTransaction> list = new ArrayList<BankTransaction>();
		BankTransaction bankTrans = 
				new BankTransaction(1, LocalDateTime.now(), 450.00,
						new TransactionType(1, "X", "X"), new Customer(1, "x","x"), new BankAccount(1, 123.00, new Account(1, (long) 123, (long) 1234,""), new Customer()));
		list.add(bankTrans);
		return BankTransactionResponse.convertToList(list);
		
	}

}
