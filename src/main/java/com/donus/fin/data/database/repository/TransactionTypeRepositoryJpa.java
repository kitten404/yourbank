package com.donus.fin.data.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.fin.data.database.entity.TransactionTypeData;

public interface TransactionTypeRepositoryJpa extends JpaRepository<TransactionTypeData, Integer>{

}
