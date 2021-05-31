package com.donus.fin.core.usecase.transactiontype;

import com.donus.fin.core.domain.TransactionType;

public interface TransactionTypeRepository {
	
	TransactionType findById(Integer id);

}
