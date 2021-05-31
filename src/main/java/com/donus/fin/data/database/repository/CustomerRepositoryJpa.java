package com.donus.fin.data.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donus.fin.data.database.entity.CustomerData;


public interface CustomerRepositoryJpa extends JpaRepository<CustomerData, Integer> {

}
