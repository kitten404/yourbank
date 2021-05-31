package com.donus.fin.core.usecase.banktransaction.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {
	
	private String dateException;
	private String message;
	
	public static MessageResponse createResponse(String message) {
		return MessageResponse.builder()
				.dateException(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
				.message(message)
				.build();
	}

}
