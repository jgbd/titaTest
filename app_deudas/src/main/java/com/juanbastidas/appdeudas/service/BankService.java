package com.juanbastidas.appdeudas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juanbastidas.appdeudas.entity.Bank;

public interface BankService {
	public Iterable<Bank> findAll();
	
	public Page<Bank> findAll(Pageable pageable);
	
	public Optional<Bank> findById(Long id);
	
	public Bank save(Bank bank);
	
	public void deleteById(Long id);
}
