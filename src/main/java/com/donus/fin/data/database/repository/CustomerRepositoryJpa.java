package com.donus.fin.data.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donus.fin.data.database.entity.CustomerData;

@Repository
public interface CustomerRepositoryJpa extends JpaRepository<CustomerData, Integer> {

}
