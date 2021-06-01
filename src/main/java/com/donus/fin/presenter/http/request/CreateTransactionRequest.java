package com.donus.fin.presenter.http.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class CreateTransactionRequest {
	
	@NotNull
	@Positive
	private Double valor;
	
	@NotNull
	private Long agenciaRemetente;
	
	@NotNull
	private Long contaRemetente;
	
	@NotNull
	private Long agenciaReceptora;
	
	@NotNull
	private Long contaReceptora;

	@NotNull
	private int tipoTransacao;

}
