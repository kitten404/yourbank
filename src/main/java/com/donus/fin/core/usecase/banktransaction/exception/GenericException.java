package com.donus.fin.core.usecase.banktransaction.exception;

import java.util.List;

import lombok.Getter;

@Getter
public class GenericException extends RuntimeException{
	
	private int codErro;
	private String mensagem;
	
	public GenericException(int codErro, String mensagem, Throwable cause) {
		super(mensagem, cause);
		this.codErro = codErro;
		this.mensagem = mensagem;
	}

}
