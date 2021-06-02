package com.donus.fin.presenter.http.entrypoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donus.fin.core.usecase.banktransaction.CreateBankTransactionUseCase;
import com.donus.fin.presenter.http.request.CreateTransactionRequest;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@RestController
@RequestMapping("/v1/bank-transaction")
public class BankTransactionEntryPoint {
	
	@Autowired
	private CreateBankTransactionUseCase createBankTransactionUseCase;
	
	//cria transação bancária
	@PostMapping
	public ResponseEntity<BankTransactionResponse> createBankTransaction(@RequestBody @Valid CreateTransactionRequest request) {
		return ResponseEntity.ok().body(createBankTransactionUseCase.execute(request));
	}

}
