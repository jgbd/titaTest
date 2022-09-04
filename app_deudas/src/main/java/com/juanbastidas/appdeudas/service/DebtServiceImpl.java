/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.juanbastidas.appdeudas.entity.Debt;
import com.juanbastidas.appdeudas.repository.DebtRepository;

@Service
public class DebtServiceImpl implements DebtService {
	@Autowired
	private DebtRepository debtRepository;
	
	@Override
	public Iterable<Debt> findAll() {
		return debtRepository.findAll();
	}

	@Override
	public Page<Debt> findAll(Pageable pageable) {
		return debtRepository.findAll(pageable);
	}

	@Override
	public Optional<Debt> findById(Long id) {
		return debtRepository.findById(id);
	}

	@Override
	public Debt save(Debt debt) {
		return debtRepository.save(debt);
	}

	@Override
	public void deleteById(Long id) {
		debtRepository.deleteById(id);
	}

}
