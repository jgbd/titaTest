/*
 * author: Juan Bastidas
 * */
package com.juanbastidas.appdeudas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juanbastidas.appdeudas.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
