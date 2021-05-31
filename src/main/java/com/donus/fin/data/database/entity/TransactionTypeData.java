package com.donus.fin.data.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.donus.fin.core.domain.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TRANSACTION_TYPE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionTypeData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, nullable = false)
	private String codTransacao;
	private String descricao;
	
	public static TransactionTypeData convert(TransactionType transactionType) {
		return TransactionTypeData.builder()
		.codTransacao(transactionType.getCodTransacao())
		.descricao(transactionType.getDescricao())
		.id(transactionType.getId())
		.build();
	}
	
	public TransactionType convert() {
		return new TransactionType(
				id,
				codTransacao,
				descricao
				);
		
	}

}
