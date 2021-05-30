package com.donus.fin.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	
	private Integer id;
	private String cpf;
	private String nome;

}
