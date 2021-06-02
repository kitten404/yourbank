package com.donus.fin.presenter.http.entrypoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donus.fin.core.usecase.bankaccount.CreateBankAccountUseCase;
import com.donus.fin.presenter.http.request.CreateBankAccountRequest;
import com.donus.fin.presenter.http.response.BankAccountResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/bank-account")
@AllArgsConstructor
public class BankAccountEntryPoint {
	
	@Autowired
	private CreateBankAccountUseCase createBankAccountUseCase;
	
	//Abre conta no banco
	@PostMapping
	public ResponseEntity<BankAccountResponse> createBankAccount(@RequestBody @Valid CreateBankAccountRequest request){
		return ResponseEntity.ok().body(createBankAccountUseCase.execute(request));
	}

}
