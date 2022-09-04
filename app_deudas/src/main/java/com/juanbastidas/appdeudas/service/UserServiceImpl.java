/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanbastidas.appdeudas.entity.Bank;
import com.juanbastidas.appdeudas.entity.User;
import com.juanbastidas.appdeudas.entity.UserBank;
import com.juanbastidas.appdeudas.repository.BankRepository;
import com.juanbastidas.appdeudas.repository.DebtRepository;
import com.juanbastidas.appdeudas.repository.UserBankRepository;
import com.juanbastidas.appdeudas.repository.UserRepository;
import com.juanbastidas.appdeudas.response.DebtResponse;
import com.juanbastidas.appdeudas.response.UserBankDebt;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private DebtRepository debtRepository;
	@Autowired
	private UserBankRepository userBankRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<UserBankDebt> getBankAndDebtById(Long id_user) {
		Optional<UserBankDebt> oUserBankDebt = Optional.empty();
		List<List <DebtResponse>> debt = new ArrayList<List<DebtResponse>>();
		List<Bank> bank = new ArrayList<Bank>();
		
		Optional<User> user = userRepository.findById(id_user);
		
		List<UserBank> lstUserBank = userBankRepository.findByUser_Id(user.get().getId());
		for (UserBank userBank : lstUserBank) {
			System.out.println(userBank.getId());
			debt.add(debtRepository.findByUserBank_Id(userBank.getId()));
			Optional<Bank> b = bankRepository.findById(userBank.getBank().getId());
			if(!b.isEmpty()) bank.add(b.get());
        }
		
		UserBankDebt uesrBankDebt = new UserBankDebt(user.get(), bank, debt);
		
		oUserBankDebt = Optional.of(uesrBankDebt);
		return oUserBankDebt;
	}

	
}
