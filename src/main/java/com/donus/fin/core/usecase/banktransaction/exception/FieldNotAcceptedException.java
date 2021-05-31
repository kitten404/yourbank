package com.donus.fin.core.usecase.banktransaction.exception;

public class FieldNotAcceptedException extends Exception{

	private static final long serialVersionUID = 1L;

	public FieldNotAcceptedException(String message, Throwable cause) {
		super(message, cause);
	}
}
