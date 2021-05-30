package com.donus.fin.data.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.donus.fin.core.domain.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountData {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private Long conta;
	@Column(nullable = false)
	private Long agencia;
	@Column(nullable = false)
	private String digito;
	
	public Account convert() {
		return new Account(
				id,
				conta,
				agencia,
				digito
				);
	}
	
	public static AccountData convert(Account account) {
		return new AccountData(
				account.getId(),
				account.getConta(),
				account.getAgencia(),
				account.getDigito()
				);
	}

}
