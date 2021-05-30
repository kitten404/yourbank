package com.donus.fin.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
	private Integer id;
	private Double valor;
	private Account conta;
	private Customer customer;
}
