/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanbastidas.appdeudas.entity.Bank;
import com.juanbastidas.appdeudas.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Bank> findAll() {
		return bankRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Bank> findAll(Pageable pageable) {
		return bankRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Bank> findById(Long id) {
		return bankRepository.findById(id);
	}

	@Override
	@Transactional
	public Bank save(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		bankRepository.deleteById(id);
	}
}
