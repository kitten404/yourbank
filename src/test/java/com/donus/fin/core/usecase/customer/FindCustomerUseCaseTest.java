package com.donus.fin.core.usecase.customer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Customer;

@SpringBootTest
public class FindCustomerUseCaseTest {
	
	@Mock
	private CustomerRepository repository;
	
	@InjectMocks
	private FindCustomerUseCase findCustomerUseCase;
	
	@Test
	public void execute() {
		
		Mockito.when(repository.findById(1))
			.thenReturn(new Customer(1,"X","X"));
		
		Assert.assertNotNull(findCustomerUseCase.execute(1));
		
	}

}
