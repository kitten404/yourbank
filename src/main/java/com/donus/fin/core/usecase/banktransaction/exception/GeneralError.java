package com.donus.fin.core.usecase.banktransaction.exception;

public class GeneralError extends GenericException{
	
	public GeneralError() {
		super(500, "Erro Interno !",null);
	}

}
