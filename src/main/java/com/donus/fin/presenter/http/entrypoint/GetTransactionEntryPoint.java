package com.donus.fin.presenter.http.entrypoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donus.fin.core.usecase.banktransaction.GetTransactionUseCase;

@RestController
@RequestMapping(value = "/v1/bank-transaction")
public class GetTransactionEntryPoint {
	
	@Autowired
	private GetTransactionUseCase getTransactionUseCase;
	
	@GetMapping
	public ResponseEntity<?> getTransactionByAccount(@Valid @RequestParam Long agencia, @RequestParam Long conta) {
		return ResponseEntity.ok(
					getTransactionUseCase.getTransactionByAccount(agencia, conta)
				);
	}

}
