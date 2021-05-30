package com.donus.fin.core.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankTransaction {
	
	private int id;
	private LocalDateTime data;
	private Double valor;
	private TipoTransacao tipoTransacao;
	private Customer customer;
	private BankAccount receiver;

}
