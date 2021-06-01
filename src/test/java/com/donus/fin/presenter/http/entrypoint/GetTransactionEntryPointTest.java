package com.donus.fin.presenter.http.entrypoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.BankTransaction;
import com.donus.fin.core.domain.Customer;
import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.banktransaction.GetTransactionUseCase;
import com.donus.fin.core.usecase.banktransaction.exception.NotFoundException;
import com.donus.fin.core.usecase.banktransaction.exception.RestException;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@SpringBootTest
public class GetTransactionEntryPointTest {
	
	
	private MockMvc mockMvc;
	
	@Mock
	private GetTransactionUseCase getTransactionUseCase;
	
	@InjectMocks
	private GetTransactionEntryPoint getTransactionEntryPoint;
	
	@Test
	public void getTransactionEntryPoint() {
		
		Mockito.when(getTransactionUseCase.getTransactionByAccount((long)123, (long)1234))
		.thenReturn(responseOK());
		
		ResponseEntity<?> response = 
				getTransactionEntryPoint.getTransactionByAccount((long)123, (long)1234);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	private List<BankTransactionResponse> responseOK() {
		List<BankTransaction> list = new ArrayList<BankTransaction>();
		BankTransaction bankTrans = 
				new BankTransaction(1, LocalDateTime.now(), 450.00,
						new TransactionType(1, "X", "X"), new Customer(1, "x","x"), new BankAccount(1, 123.00, new Account(1, (long) 123, (long) 1234,""), new Customer()));
		list.add(bankTrans);
		return BankTransactionResponse.convertToList(list);
		
	}
	@Test
	public void whenNoHandlerForHttpRequest_thenNotFound() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(RestException.class).setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver()).build();
		
		 MvcResult mvcResult  = mockMvc.perform(get("/v1/bank-transaction")
				.contentType(MediaType.APPLICATION_JSON)
				.param("conta", "123")
				.param("agencia", "1234")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound())
		.andReturn();
		
		//Assert.assertTrue(mvcResult.getResponse().getContentAsString().contains("Recurso não Encontrado!"));
	}

}
