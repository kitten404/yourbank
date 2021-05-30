package com.donus.fin.core.usecase.customer;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.Customer;
import com.donus.fin.presenter.http.request.CreateBankAccountRequest;

public class CreateCustomerUseCase {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer execute(CreateBankAccountRequest request) {
		Customer customer = new Customer(
				null,
				request.getCpf(),
				request.getNome()
				);
		
		return repository.create(customer);
	}

}
