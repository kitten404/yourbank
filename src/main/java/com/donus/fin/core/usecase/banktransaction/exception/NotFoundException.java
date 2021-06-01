package com.donus.fin.core.usecase.banktransaction.exception;


public class NotFoundException extends GenericException{
	
	public NotFoundException() {
		super(404, "Recurso não Encontrado!",null);
	}

}
