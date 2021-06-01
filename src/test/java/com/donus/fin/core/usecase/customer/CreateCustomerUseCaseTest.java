package com.donus.fin.core.usecase.customer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.donus.fin.core.domain.Customer;
import com.donus.fin.presenter.http.request.CreateBankAccountRequest;

@SpringBootTest
public class CreateCustomerUseCaseTest {
	
	@Mock
	private CustomerRepository repository;
	@InjectMocks
	private CreateCustomerUseCase createCustomerUseCase;
	
	@Test
	public void execute() {
		Customer customer = createCustomer();
		customer.setId(null);
		Mockito.when(repository.create(customer))
			.thenReturn(createCustomer());
		
		Assert.assertNotNull(createCustomerUseCase.execute(createRequestOK()));
	}
	
	private Customer createCustomer() {
		return new Customer(1, "12325232523","Teste Teste");
	}
	
	private CreateBankAccountRequest createRequestOK() {
		CreateBankAccountRequest request = new CreateBankAccountRequest();
		request.setAgencia((long)9399);
		request.setCpf("12325232523");
		request.setNome("Teste Teste");
		return request;
	}
	

}
