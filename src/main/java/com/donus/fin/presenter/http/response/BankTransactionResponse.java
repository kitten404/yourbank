package com.donus.fin.presenter.http.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	
	public static BankTransactionResponse response(BankTransaction bankTrans) {
		return BankTransactionResponse.builder()
		.data(bankTrans.getData())
		.conta(bankTrans.getReceiver().getConta().getConta())
		.agencia(bankTrans.getReceiver().getConta().getAgencia())
		.digito(bankTrans.getReceiver().getConta().getDigito())
		.valor(bankTrans.getValor())
		.tipoTransacao(bankTrans.getTipoTransacao().getDescricao())
		.build();
	}
	
	public static List<BankTransactionResponse> convertToList(List<BankTransaction> bankTrans){
		List<BankTransactionResponse> list = new ArrayList<BankTransactionResponse>();
		bankTrans.forEach(e -> {
			list.add(response(e));
		});
		return list;
	}

}
