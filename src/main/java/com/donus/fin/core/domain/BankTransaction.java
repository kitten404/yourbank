package com.donus.fin.core.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankTransaction {
	
	private Integer id;
	private LocalDateTime data;
	private Double valor;
	private TransactionType tipoTransacao;
	private Customer customer;
	private BankAccount receiver;

}
