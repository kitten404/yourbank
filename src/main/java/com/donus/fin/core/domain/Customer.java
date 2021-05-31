package com.donus.fin.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private Integer id;
	private String cpf;
	private String nome;

}
