package com.donus.fin.data.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.transactiontype.TransactionTypeRepository;
import com.donus.fin.data.database.entity.TransactionTypeData;

@Repository
public class TransactionTypeRepositoryImpl implements TransactionTypeRepository{
	
	@Autowired
	private TransactionTypeRepositoryJpa repository;
	
	@Override
	public TransactionType findById(Integer id) {
		TransactionTypeData transactionTypeData = repository.getOne(id);
		return transactionTypeData.convert();
	}

}
