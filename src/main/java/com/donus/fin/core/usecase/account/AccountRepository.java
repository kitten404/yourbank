package com.donus.fin.core.usecase.account;

import com.donus.fin.core.domain.Account;

public interface AccountRepository {
	
	Account create(Account account);
	
	Long findLastAccount(Long agencia);

}
