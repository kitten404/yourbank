package com.donus.fin.data.database.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.data.database.entity.TransactionTypeData;

@SpringBootTest
public class TransactionTypeRepositoryImplTest {
	
	@Mock
	private TransactionTypeRepositoryJpa repository;
	@InjectMocks
	private TransactionTypeRepositoryImpl transactionTypeRepositoryImpl;
	
	@Test
	public void findByIdOk() {
		
		Mockito.when(repository.getOne(1))
			.thenReturn(new TransactionTypeData(1,"",""));
		
		TransactionType tp =
				transactionTypeRepositoryImpl.findById(1);
		
		Assert.assertEquals(tp.getId(), 1);		
		
	}
	
	@Test
	public void findByIdNOk() {
		
		Mockito.when(repository.getOne(1))
			.thenReturn(null);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			transactionTypeRepositoryImpl.findById(1);
		 });	
		
	}

}
