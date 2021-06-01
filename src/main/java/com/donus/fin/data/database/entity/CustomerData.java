package com.donus.fin.data.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.donus.fin.core.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, nullable = false)
	private String cpf;
	@Column(nullable = false)
	private String nome;
	
	public static CustomerData convert(Customer customer) {
		return CustomerData.builder()
				.id(customer.getId())
				.nome(customer.getNome())
				.cpf(customer.getCpf())
				.build();
		
	}
	
	public Customer convert() {
		return new Customer(
				id,
				cpf,
				nome
				);
				
	}

}
