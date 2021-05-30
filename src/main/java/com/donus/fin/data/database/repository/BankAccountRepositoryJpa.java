package com.donus.fin.data.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.fin.data.database.entity.BankAccountData;

public interface BankAccountRepositoryJpa extends JpaRepository<BankAccountData, Integer>{

}
