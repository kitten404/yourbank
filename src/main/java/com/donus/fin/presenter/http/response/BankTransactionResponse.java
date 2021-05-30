package com.donus.fin.presenter.http.response;

import java.time.LocalDateTime;

import com.donus.fin.core.domain.BankTransaction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankTransactionResponse {
	
	private LocalDateTime data;
	private Double valor;
	private String tipoTransacao;
	private Long conta;
	private Long agencia;
	private String digito;
	
	public BankTransactionResponse response(BankTransaction bankTrans) {
		return BankTransactionResponse.builder()
		.data(bankTrans.getData())
		.valor(bankTrans.getValor())
		.tipoTransacao(bankTrans.getTipoTransacao().getDescricao())
		.build();
	}

}
