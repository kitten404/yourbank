package com.donus.fin.data.database.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.donus.fin.core.domain.BankTransaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TRANSFER_ORDER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankTransactionData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_customer", nullable = false)
	private CustomerData customer;
	
	@Column(nullable = false)
	private LocalDateTime data;
	
	@Column(nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="id_transaction", nullable = false)
	private TransactionTypeData tipoTransacao;
	
	@ManyToOne
	@JoinColumn(name="id_bankAccount", nullable = false)
	private BankAccountData receiver;
	
	public static BankTransactionData convert(BankTransaction bankTransaction) {
		return BankTransactionData.builder()
				.customer(CustomerData.convert(bankTransaction.getCustomer()))
				.id(bankTransaction.getId())
				.data(bankTransaction.getData())
				.valor(bankTransaction.getValor())
				.receiver(BankAccountData.convert(bankTransaction.getReceiver()))
				.tipoTransacao(TransactionTypeData.convert(bankTransaction.getTipoTransacao()))
				.build();
	}
	
	public BankTransaction convert() {
		return new BankTransaction(
					id,
					data,
					valor,
					tipoTransacao.convert(),
					customer.convert(),
					receiver.convert()
				);
	}

}
