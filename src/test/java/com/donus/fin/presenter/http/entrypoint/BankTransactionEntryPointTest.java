package com.donus.fin.presenter.http.entrypoint;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.donus.fin.core.usecase.banktransaction.CreateBankTransactionUseCase;
import com.donus.fin.presenter.http.request.CreateTransactionRequest;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@SpringBootTest
public class BankTransactionEntryPointTest {
	
	@Mock
	private CreateBankTransactionUseCase createBankTransactionUseCase;
	
	@InjectMocks
	private BankTransactionEntryPoint bankTransactionEntryPoint;
	
	@Test
	public void createTransactionEntryPoint() {
		
		Mockito.when(createBankTransactionUseCase.execute(requestOk()))
		.thenReturn(responseOk());
		
		ResponseEntity<BankTransactionResponse> response = 
				bankTransactionEntryPoint.createBankTransaction(requestOk());
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(response.getBody().getConta(), responseOk().getConta());
	}
	
	private BankTransactionResponse responseOk() {
		return BankTransactionResponse.builder()
				.agencia((long)123)
				.conta((long)1234)
				.data(LocalDateTime.now())
				.digito("X")
				.valor(290.90)
				.tipoTransacao("DOC")
				.build();
	}
	
	private CreateTransactionRequest requestOk() {
		CreateTransactionRequest request = new CreateTransactionRequest();
		request.setValor(290.90);
		request.setTipoTransacao(1);
		request.setContaReceptora((long)123);
		request.setAgenciaReceptora((long)1234);
		return request;
	}

}
