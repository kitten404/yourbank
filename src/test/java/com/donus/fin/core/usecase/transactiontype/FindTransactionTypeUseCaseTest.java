package com.donus.fin.core.usecase.transactiontype;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.TransactionType;

@SpringBootTest
public class FindTransactionTypeUseCaseTest {
	
	@Mock
	private TransactionTypeRepository repository;
	
	@InjectMocks
	private FindTransactionTypeUseCase findTransactionTypeUseCase;
	
	@Test
	public void execute() {
		
		Mockito.when(repository.findById(1))
			.thenReturn(new TransactionType(1,"X","X"));
		
		Assert.assertNotNull(findTransactionTypeUseCase.execute(1));
		
	}

}
