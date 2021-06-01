package com.donus.fin.data.database.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.data.database.entity.CustomerData;

@SpringBootTest
public class CustomerRepositoryImplemTest {
	
	@Mock
	private CustomerRepositoryJpa repository;
	@InjectMocks
	private CustomerRepositoryImplem customerRepositoryImplem;
	
	@Test
	public void createOK() {
		
		Mockito.when(repository.save(createCustomerData()))
			.thenReturn(createCustomerDataReturn());
		
		Customer customer =
				customerRepositoryImplem.create(createCustomer());
		
		Assert.assertNotNull(customer);
	}
	
	@Test
	public void findByIdOK() {
		
		Mockito.when(repository.getOne(1))
			.thenReturn(createCustomerDataReturn());
		
		Customer customer =
				customerRepositoryImplem.findById(1);
		
		Assert.assertNotNull(customer);
	}
	
	@Test
	public void findByIdNOk() {
		
		Mockito.when(repository.getOne(1))
		.thenReturn(null);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			customerRepositoryImplem.findById(1);
		 });	
		
	}
	
	private CustomerData createCustomerData() {
		return new CustomerData(null, "12325232523","Teste Teste");
	}
	
	private CustomerData createCustomerDataReturn() {
		return new CustomerData(1, "12325232523","Teste Teste");
	}
	
	private Customer createCustomer() {
		return new Customer(null, "12325232523","Teste Teste");
	}

}
