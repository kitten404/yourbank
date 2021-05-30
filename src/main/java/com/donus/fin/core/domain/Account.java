package com.donus.fin.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Account {
	
	private Integer id;
	private Long conta;
	private Long agencia;
	private String digito;

}
