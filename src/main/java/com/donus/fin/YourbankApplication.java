package com.donus.fin;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.donus.fin.data.database.entity.AccountData;
import com.donus.fin.data.database.entity.BankAccountData;
import com.donus.fin.data.database.entity.CustomerData;
import com.donus.fin.data.database.entity.TransactionTypeData;
import com.donus.fin.data.database.repository.AccountRepositoryJpa;
import com.donus.fin.data.database.repository.BankAccountRepositoryJpa;
import com.donus.fin.data.database.repository.CustomerRepositoryJpa;
import com.donus.fin.data.database.repository.TransactionTypeRepositoryJpa;


@SpringBootApplication
public class YourbankApplication implements CommandLineRunner{
	
	@Autowired
	private TransactionTypeRepositoryJpa tipoTransacaoRepository;
	
	@Autowired
	private AccountRepositoryJpa accountRepositoryJpa;
	
	@Autowired
	private CustomerRepositoryJpa cusomerRepositoryJpa;
	
	@Autowired
	private BankAccountRepositoryJpa bankAccountRepositoryJpa;

	public static void main(String[] args) {
		SpringApplication.run(YourbankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tipoTransacaoRepository.save(new TransactionTypeData(1,"DOC","Documento de Ordem de Crédito"));
		tipoTransacaoRepository.save(new TransactionTypeData(2,"TED","Transferência Eletrônica Disponível"));
		tipoTransacaoRepository.save(new TransactionTypeData(3,"DEPOSITO","Depósito"));
		
		AccountData accountData1 = new AccountData(null,(long)2900,(long)2390,"X");
		AccountData accountData2 = new AccountData(null,(long)29011, (long)2390,"X");
		AccountData accountData3 = new AccountData(null,(long)39130, (long)2456,"X");
		
		accountRepositoryJpa.saveAll
			(Arrays.asList(accountData1,accountData2,accountData3));
		
		CustomerData customerData1 = new CustomerData(null, "19495839381", "Ana Paula");
		CustomerData customerData2 = new CustomerData(null, "35474950698", "Quezia Chan");
		CustomerData customerData3 = new CustomerData(null, "94758393038", "Guilherme Souza");
		
		cusomerRepositoryJpa.saveAll(Arrays.asList(customerData1,customerData2,customerData3));
		
		bankAccountRepositoryJpa.save(new BankAccountData(null,customerData1,accountData1,2000.00));
		bankAccountRepositoryJpa.save(new BankAccountData(null,customerData2,accountData2,950.00));
		bankAccountRepositoryJpa.save(new BankAccountData(null,customerData3,accountData3,1000.00));
		
	}

}
