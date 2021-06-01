package com.donus.fin.core.usecase.banktransaction.exception;

public class GeneralError extends GenericException{
	
	public GeneralError(String message) {
		super(500, message,null);
	}

}
