package com.donus.fin.data.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.usecase.customer.CustomerRepository;
import com.donus.fin.data.database.entity.CustomerData;

@Repository
public class CustomerRepositoryImplem implements CustomerRepository{
	
	@Autowired
	private CustomerRepositoryJpa repository;
	
	@Override
	public Customer create(Customer customer) {
		CustomerData customerData = CustomerData.convert(customer);
		return repository.save(customerData).convert();
	}

	@Override
	public Customer findById(Integer id) {
		CustomerData customerData = repository.getOne(id);
		return customerData.convert();
	}

}
