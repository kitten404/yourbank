package com.donus.fin.data.database.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.donus.fin.core.domain.BankTransaction;
import com.donus.fin.core.usecase.banktransaction.BankTransactionRepository;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.data.database.entity.BankTransactionData;

public class BankTransactionRepositoryImplem implements BankTransactionRepository{
	
	@Autowired
	private BankTransactionRepositoryJpa repository;
	
	@Override
	public BankTransaction createBankTransaction(BankTransaction bankTransaction) {
		BankTransactionData bankTransactionData = BankTransactionData.convert(bankTransaction);
		return repository.save(bankTransactionData).convert();
	}

	@Override
	public List<BankTransaction> getTransactionUseCaseByAccount(Integer id) {	
		return BankTransactionData.convertToList(Optional.ofNullable(repository.getTransactionByAccount(id))
			.orElseThrow(() -> {
				return new NotFoundException();
			}));
	}


}
