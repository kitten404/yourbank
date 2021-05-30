package com.donus.fin.core.usecase.customer;

import com.donus.fin.core.domain.Customer;

public interface CustomerRepository {
	
	Customer create(Customer customer);

}
