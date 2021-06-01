package com.donus.fin.core.usecase.banktransaction;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
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
import com.donus.fin.core.usecase.bankaccount.UpdateBankAccountUseCase;
import com.donus.fin.core.usecase.banktransaction.exception.GeneralError;
import com.donus.fin.core.usecase.transactiontype.FindTransactionTypeUseCase;
import com.donus.fin.presenter.http.request.CreateTransactionRequest;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@SpringBootTest
public class CreateBankTransactionUseCaseTest {
	
	@Mock
	private FindTransactionTypeUseCase transactionTypeUseCase;
	@Mock
	private FindAccountUseCase findAccountUseCase;
	@Mock
	private FindBankAccountUseCase findBankAccountUseCase;
	@Mock
	private UpdateBankAccountUseCase updateBankAccountUseCase;
	@Mock
	private BankTransactionRepository repository;
	
	@InjectMocks
	private CreateBankTransactionUseCase createBankTransactionUseCase;
	
	@Test
	public void executeOK() {
		
		Mockito.when(transactionTypeUseCase.execute(1))
			.thenReturn(new TransactionType(1,"X","X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 12345))
		.thenReturn(new Account(1,(long)123,(long) 12345, "X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 90525))
		.thenReturn(new Account(2,(long)123,(long) 90525, "X"));
		
		Mockito.when(findBankAccountUseCase.execute(1))
		.thenReturn(contaRemetente());
		
		Mockito.when(findBankAccountUseCase.execute(2))
		.thenReturn(contaReceptora());
		
		Mockito.when(updateBankAccountUseCase.execute(contaRemetenteAfterTrans()))
			.thenReturn(contaRemetenteAfterTrans());
		
		Mockito.when(updateBankAccountUseCase.execute(contaReceptoraAfterTrans()))
		.thenReturn(contaReceptoraAfterTrans());
		
		Mockito.when(repository.createBankTransaction(createTransaction()))
			.thenReturn(createTransactionReturn());
		
		BankTransactionResponse response =
				createBankTransactionUseCase.execute(createRequestOK());
		
		Assert.assertNotNull(response);
		Assert.assertEquals(response.getConta(), contaReceptora().getConta().getConta());
		
	}
	
	@Test
	public void executeExceptionDeposito() {
		
		Mockito.when(transactionTypeUseCase.execute(3))
			.thenReturn(new TransactionType(3,"DEPOSITO","X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 12345))
		.thenReturn(new Account(1,(long)123,(long) 12345, "X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 90525))
		.thenReturn(new Account(2,(long)123,(long) 90525, "X"));
		
		Mockito.when(findBankAccountUseCase.execute(1))
		.thenReturn(contaRemetente());
		
		Mockito.when(findBankAccountUseCase.execute(2))
		.thenReturn(contaReceptora());
		
		CreateTransactionRequest request = createRequestOK();
		request.setTipoTransacao(3);
		request.setValor(200000.00);
		
		Assertions.assertThrows(GeneralError.class, () -> {
			createBankTransactionUseCase.execute(request);
		 });
	}
	
	@Test
	public void executeDepositoOK() {
		
		Mockito.when(transactionTypeUseCase.execute(3))
			.thenReturn(new TransactionType(3,"DEPOSITO","X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 12345))
		.thenReturn(new Account(1,(long)123,(long) 12345, "X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 90525))
		.thenReturn(new Account(2,(long)123,(long) 90525, "X"));
		
		Mockito.when(findBankAccountUseCase.execute(1))
		.thenReturn(contaRemetente());
		
		Mockito.when(findBankAccountUseCase.execute(2))
		.thenReturn(contaReceptora());
		
		CreateTransactionRequest request = createRequestOK();
		request.setTipoTransacao(3);
		request.setValor(90.00);
		
		Assertions.assertThrows(Exception.class, () -> {
			createBankTransactionUseCase.execute(request);
		 });
	}
	
	@Test
	public void LimiteException() {
		
		Mockito.when(transactionTypeUseCase.execute(1))
			.thenReturn(new TransactionType(1,"X","X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 12345))
		.thenReturn(new Account(1,(long)123,(long) 12345, "X"));
		
		Mockito.when(findAccountUseCase.execute((long)123,(long) 90525))
		.thenReturn(new Account(2,(long)123,(long) 90525, "X"));
		
		Mockito.when(findBankAccountUseCase.execute(1))
		.thenReturn(contaRemetente());
		
		Mockito.when(findBankAccountUseCase.execute(2))
		.thenReturn(contaReceptora());
		
		CreateTransactionRequest request = createRequestOK();
		request.setValor(200000.00);
		
		Assertions.assertThrows(GeneralError.class, () -> {
			createBankTransactionUseCase.execute(request);
		 });
	}
	
	private CreateTransactionRequest createRequestOK() {
		CreateTransactionRequest request = new CreateTransactionRequest();
		request.setValor(390.95);
		request.setAgenciaRemetente((long) 123);
		request.setContaRemetente((long)12345);
		request.setAgenciaReceptora((long) 123);
		request.setContaReceptora((long)90525);
		request.setTipoTransacao(1);
		
		return request;
	}
	
	private BankAccount contaRemetente() {
		return new BankAccount(1, 1200.25, accountRemetente(), customerRemetente());
	}
	
	private BankAccount contaReceptora() {
		return new BankAccount(2, 200.00, accountReceptora(), customerReceptor());
	}
	
	private BankAccount contaRemetenteAfterTrans() {
		return new BankAccount(1, 809.30, accountRemetente(), customerRemetente());
	}
	
	private BankAccount contaReceptoraAfterTrans() {
		return new BankAccount(2, 590.95, accountReceptora(), customerReceptor());
	}
	
	private Account accountReceptora() {
		return new Account(2,(long)90525,(long) 123, "X");
	}
	
	private Account accountRemetente() {
		return new Account(1,(long)12345,(long) 123, "X");
	}
	
	private Customer customerRemetente() {
		return new Customer(1,"12356485623","Customer one");
	}
	
	private Customer customerReceptor() {
		return new Customer(2,"12354798659","Customer two");
	}
	
	private BankTransaction createTransaction() {
		return  
				new BankTransaction(null, Mockito.any(), 390.95, 
						new TransactionType(1,"X","X"), customerRemetente(), contaReceptoraAfterTrans());
	}
	
	private BankTransaction createTransactionReturn() {
		return  
				new BankTransaction(1, Mockito.any(), 390.95, 
						new TransactionType(1,"X","X"), customerRemetente(), contaReceptoraAfterTrans());
	}

}
