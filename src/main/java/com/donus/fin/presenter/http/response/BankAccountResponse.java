package com.donus.fin.presenter.http.response;

import com.donus.fin.core.domain.BankAccount;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccountResponse {
	
	private String nome;
	private String cpf;
	private String conta;
	private Long agencia;
	private String digito;
	private Double valor;
	
	public static BankAccountResponse response(BankAccount bankAccount) {
		return BankAccountResponse.builder()
		.nome(bankAccount.getCustomer().getNome())
		.cpf(bankAccount.getCustomer().getCpf())
		.agencia(bankAccount.getConta().getAgencia())
		.conta(stringFormat
				(bankAccount.getConta().getConta()))
		.digito(bankAccount.getConta().getDigito())
		.valor(bankAccount.getValor())
		.build();
	}
	
	private static String stringFormat(Long val) {
		return String.format("%07d", val);
	}

}
