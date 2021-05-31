package com.donus.fin.presenter.http.request;

import lombok.Data;

@Data
public class GetTransactionRequest {
	
	private Long agencia;
	private Long conta;

}
