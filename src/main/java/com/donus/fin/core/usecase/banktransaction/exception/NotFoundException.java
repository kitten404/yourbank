package com.donus.fin.core.usecase.banktransaction.exception;

import java.util.Collections;

public class NotFoundException extends GenericException{
	
	public NotFoundException() {
		super(404, "Recurso não Encontrado!",null);
	}

}
