package com.donus.fin.data.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.donus.fin.core.domain.BankAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BANK_ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_customer", nullable = false)
	private CustomerData customer;
	
	@ManyToOne
	@JoinColumn(name="id_account", nullable = false, unique = true)
	private AccountData conta;

	@Column(nullable = false)
	private Double valor;
	
	public static BankAccountData convert(BankAccount bankAccount) {
		return BankAccountData.builder()
				.id(bankAccount.getId())
				.valor(bankAccount.getValor())
				.customer(CustomerData.convert(bankAccount.getCustomer()))
				.conta(AccountData.convert(bankAccount.getConta()))
				.build();
	}
	
	public BankAccount convert() {
		return new BankAccount(
				id,
				valor,
				conta.convert(),
				customer.convert()
				);
	}
	

}
