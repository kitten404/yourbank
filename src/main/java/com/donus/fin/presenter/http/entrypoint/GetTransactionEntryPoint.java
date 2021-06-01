package com.donus.fin.presenter.http.entrypoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donus.fin.core.usecase.banktransaction.GetTransactionUseCase;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

@RestController
@RequestMapping(value = "/v1/bank-transaction")
public class GetTransactionEntryPoint {
	
	@Autowired
	private GetTransactionUseCase getTransactionUseCase;
	
	@GetMapping
	public ResponseEntity<List<BankTransactionResponse>> getTransactionByAccount(@Valid @RequestParam Long agencia, @RequestParam Long conta) {
		return ResponseEntity.ok(
					getTransactionUseCase.getTransactionByAccount(agencia, conta)
				);
	}

}
