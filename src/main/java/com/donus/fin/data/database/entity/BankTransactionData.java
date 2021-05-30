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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TRANSFER_ORDER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankTransactionData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_customer", nullable = false)
	private CustomerData customer;
	
	@Column(nullable = false)
	private LocalDateTime data;
	
	@Column(nullable = false)
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name="id_transaction", nullable = false)
	private TipoTransacaoData tipoTransacao;
	
	@ManyToOne
	@JoinColumn(name="id_bankAccount", nullable = false)
	private BankAccountData receiver;

}
