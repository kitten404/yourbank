package com.donus.fin.presenter.http.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateBankAccountRequest {
	
	@NotEmpty(message = "Digite o nome corretamente")
	@Size(min=5, max=100)	
	private String nome;
	
	@NotEmpty(message ="Digite o cpf corretamente")
	@Size(max=11)
	private String cpf;
	
	@NotNull
	private Long agencia;

}
