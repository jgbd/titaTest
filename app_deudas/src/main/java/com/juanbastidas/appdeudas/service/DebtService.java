/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juanbastidas.appdeudas.entity.Debt;

public interface DebtService {
	public Iterable<Debt> findAll();
	
	public Page<Debt> findAll(Pageable pageable);
	
	public Optional<Debt> findById(Long id);
	
	public Debt save(Debt debt);
	
	public void deleteById(Long id);
}
