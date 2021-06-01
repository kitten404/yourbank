package com.donus.fin.core.usecase.banktransaction;

import java.time.LocalDateTime;

import com.donus.fin.core.domain.Account;
import com.donus.fin.core.domain.BankAccount;
import com.donus.fin.core.domain.BankTransaction;
import com.donus.fin.core.domain.TransactionType;
import com.donus.fin.core.usecase.account.FindAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.FindBankAccountUseCase;
import com.donus.fin.core.usecase.bankaccount.UpdateBankAccountUseCase;
import com.donus.fin.core.usecase.banktransaction.exception.GeneralError;
import com.donus.fin.core.usecase.transactiontype.FindTransactionTypeUseCase;
import com.donus.fin.presenter.http.request.CreateTransactionRequest;
import com.donus.fin.presenter.http.response.BankTransactionResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateBankTransactionUseCase {
	
	private FindTransactionTypeUseCase transactionTypeUseCase;
	private FindAccountUseCase findAccountUseCase;
	private FindBankAccountUseCase findBankAccountUseCase;
	private UpdateBankAccountUseCase updateBankAccountUseCase;
	
	private BankTransactionRepository repository;
	
	public BankTransactionResponse execute(CreateTransactionRequest request){
		TransactionType transactionType =
				transactionTypeUseCase.execute(request.getTipoTransacao());
		
		BankAccount contaRemetente = this.checkConta(request.getAgenciaRemetente(), request.getContaRemetente());	
		BankAccount contaReceptora = this.checkConta(request.getAgenciaReceptora(), request.getContaReceptora());
		
		//valida campos e limite da conta remetente
		this.validateFields(transactionType.getCodTransacao(),request.getValor());
		this.checkLimite(request.getValor(), contaRemetente.getValor());
		this.CashTransfer(contaRemetente, contaReceptora, request.getValor());
		
		//finaliza a transacao e grava o que aconteceu
		BankTransaction bkt = new BankTransaction(null, LocalDateTime.now(),
				request.getValor(), transactionType, contaRemetente.getCustomer(), contaReceptora);
		
		return BankTransactionResponse.response(repository.createBankTransaction(bkt));
	}
	
	private void validateFields(String codTransacao, Double val) {
		if(codTransacao.equals("DEPOSITO") && val > 2000) {
			throw new GeneralError("Não é possível transacionar esse valor em depósito");
		}
	}
	
	private BankAccount checkConta(Long agencia, Long conta) {
		Account contaRepo = findAccountUseCase.execute(agencia, conta);
		BankAccount bankAccount = findBankAccountUseCase.execute(contaRepo.getId());
		return bankAccount;
	}
	
	private void checkLimite(Double valorTransfer, Double valorConta) {
		if(!(valorConta >= valorTransfer)) {
			throw new GeneralError("A conta não tem limite para transação");
		} 
	}
	
	private void CashTransfer(BankAccount contaRemetente, BankAccount contaReceptora, Double valor) {
		contaRemetente.setValor(contaRemetente.getValor() - valor);
		this.updateAccount(contaRemetente);
		contaReceptora.setValor(contaReceptora.getValor() + valor);
		this.updateAccount(contaReceptora);
	}
	
	private void updateAccount(BankAccount conta) {
		updateBankAccountUseCase.execute(conta);
	}

}
