package com.donus.fin.data.database.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.core.usecase.transactiontype.TransactionTypeRepository;

@Repository
public class TransactionTypeRepositoryImpl implements TransactionTypeRepository{
	
	@Autowired
	private TransactionTypeRepositoryJpa repository;
	
	@Override
	public TransactionType findById(Integer id) { 
		return Optional.ofNullable(repository.getOne(id))
				.orElseThrow(() -> {
					return new NotFoundException();
				}).convert();
	}

}
