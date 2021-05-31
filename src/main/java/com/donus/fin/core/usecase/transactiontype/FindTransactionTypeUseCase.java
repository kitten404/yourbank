package com.donus.fin.core.usecase.transactiontype;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.TransactionType;

public class FindTransactionTypeUseCase {
	
	@Autowired
	private TransactionTypeRepository repository;
	
	public TransactionType execute(Integer id) {
		return repository.findById(id);
	}

}
