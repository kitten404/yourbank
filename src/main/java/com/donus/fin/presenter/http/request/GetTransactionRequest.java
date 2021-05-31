package com.donus.fin.presenter.http.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GetTransactionRequest {
	
	@NotNull
	private Long agencia;
	
	@NotNull
	private Long conta;

}
