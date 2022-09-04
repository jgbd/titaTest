/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juanbastidas.appdeudas.entity.User;
import com.juanbastidas.appdeudas.response.UserBankDebt;

public interface UserService {

	public Iterable<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
	
	public Optional<UserBankDebt> getBankAndDebtById(Long Id);
}
