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
public class UpdateBankAccountUseCaseTest {
	
	@Mock
	private BankAccountRepository repository;
	
	@InjectMocks
	private UpdateBankAccountUseCase updateBankAccountUseCase;
	
	@Test
	public void execute() {
		BankAccount bk = createBank();
		bk.setId(1);
		
		Mockito.when(repository.create(createBank()))
			.thenReturn(bk);
		
		BankAccount bankAccount =
				updateBankAccountUseCase.execute(bk);
		
		Assert.assertNotEquals(bankAccount,null);
		
	}
	
	private BankAccount createBank() {
		Account account = new Account(1, (long)1, (long)9399, "X");
		Customer customer = new Customer(1, "894494939383", "Quezia Q");
		BankAccount bankAccount = new BankAccount(1, 0.0, account, customer);
		return bankAccount;
	}

}
