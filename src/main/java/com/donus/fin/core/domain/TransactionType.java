package com.donus.fin.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionType {
	
	private int id;
	private String codTransacao;
	private String descricao;

}
