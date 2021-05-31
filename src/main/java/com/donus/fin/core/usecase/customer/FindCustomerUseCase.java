package com.donus.fin.core.usecase.customer;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.Customer;

public class FindCustomerUseCase {
	
	@Autowired
	private CustomerRepository repository;
	
	public Customer execute(Integer id) {
		return repository.findById(id);
	}

}
